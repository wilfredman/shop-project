<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">

    <v-card>
        <v-card-title>
            장바구니
        </v-card-title>
    <v-data-table
            :headers="headers"
            :items="cartList"
            :rows-per-page-items="[-1]"
            hide-actions
            class="elevation-1"
    >
        <template v-slot:items="props">
            <td hidden
                v-model="props.item.id">
                {{ props.item.id }}</td>
            <td class="text-xs-left">
                <v-checkbox
                        color="indigo darken-3"
                        hide-details
                        @change="addItem(props.item, props.index)"
                ></v-checkbox>
            </td>
            <td class="text-xs-left">
                <div>상품명 : {{ props.item.name }}</div>
                <div class="font-weight-thin font-italic">
                    등록자 : {{ props.item.provider }}
                </div>
            </td>
            <td class="text-xs-left">
                {{ props.item.price }}
            </td>
            <td class="text-xs-left">
                <tr>
                    <td v-for="(text,index) in subheaders">
                    {{text}}
                    </td>
                </tr>
                <tr v-for="(option,index) in props.item.options">
                    <td>
                    {{option.color}}
                    </td>
                    <td>
                        {{option.size}}
                    </td>
                    <td>
                        {{option.quantity}}
                    </td>
                    <td>
                        <v-btn fab dark small color="pink">
                            <v-icon @click="removeFromCart(props.item, option,index, props.index)"dark>remove_shopping_cart</v-icon>
                        </v-btn>
                    </td>
                </tr>
            </td>
        </template>
    </v-data-table>
        <cart-buttom-button/>

        <div class="text-xs-center pt-4 font-weight-medium">
            구매시 총 결제 금액 : {{totalAmount}}
        </div>
    </v-card>
</template>

<script>
    import shopService from '../../services/ShopService'
    import CartButtomButton from './CartButtomButton'
  export default {
        components: {
            CartButtomButton
        },
      created() {
          // this.cartList =  this.$store.getters.cartList;
          let param = {
              userId : 1
          }
          shopService.getCartList(param).then(data => {

              console.log("data->>>>>>>", data.length,data.goods,data);
              if (data.length > 0) {
                  data.forEach(x=> {
                      x.goods['cartId'] = x.id;
                      console.log(x.goods);
                        this.cartList.push(x.goods);
                  });
                  console.log("?????",this.cartList);
              }
          })
      },
      data() {
          return {
              methodList: {
                  PREPAY : '선결제',
                  FREE : '무료',
                  OTHER : '기타'
              },
              cartList: [],
              subheaders: ['색상', '사이즈', '수량'],
              headers: [
                  { text: '선택',sortable: false },
                  { text: '목록', value: 'name',sortable: false, align: 'left' },
                  { text: '가격', value: 'price',sortable: false, align: 'left' },
                  { text: '옵션', value: 'quantity',sortable: false, align: 'left' },
              ],
          }
      },
      computed: {
          totalAmount() {
              return this.$store.getters.totalAmount;
          }
      },
      methods: {
          addItem(item,index)
          {

              console.log("addItem" ,index);

              item.options.forEach((option)=> {
                  let param = {
                      optionId : option.id,
                      price : item.price,
                      quantity: option.quantity,
                      cartId: item.cartId
                  }

                  this.$store.dispatch('updateOptionFromCart', param, option.id);
              });

              this.$store.dispatch('updateSelectedItemFromCart', index);

              this.$store.dispatch('setTotalAmount', 0);
              console.log(this.$store.getters.optionList);
              var amount = Array.from(this.$store.getters.optionList).reduce((num, item) =>
                  num + (item[1].price * item[1].quantity), 0);
              this.$store.dispatch('addTotalAmount', amount);

          },
          removeFromCart(props, option,index, propIndex) {
              let optionIds = [];
              console.log(props,option, index, propIndex);
              if(this.$store.getters.optionList.has(option.id)) {
                  var amount = option.quantity * props.price * -1;
                  this.$store.dispatch('addTotalAmount', amount);
              }
              this.$store.dispatch('deleteOptionList', option.id);

                this.cartList[propIndex].options.splice(index, 1);
                if (this.cartList[propIndex].options.length == 0) {
                    this.cartList.splice(propIndex,1);
                }
              console.log("check ", props.cartId);
              optionIds.push(option.id);
              let idList = optionIds.join(",");
                let param = {
                    optionIds : idList,
                    userId: 1
                };
              console.log(param);
                shopService.removeCart(param);
          },
          getMethod(method) {
              return this.methodList[method]? this.methodList[method] : this.methodList['OTHER'];
          }
      }
  }
</script>
