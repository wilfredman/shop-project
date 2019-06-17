<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-card>
        <v-card-title>
            상품 목록
            <v-spacer></v-spacer>

            <v-btn dark small
                   class="white--text"
                   color="info"
                   to="/cart">
                <v-icon left>shopping_cart</v-icon>
                {{itemsInCart}}
            </v-btn>
        </v-card-title>
        <v-data-table
                :headers="headers"
                :items="goods"
                :rows-per-page-items="[10]"
                :pagination.sync="pagination"
                :total-items="totalItmes"
                hide-actions
                class="elevation-1"
        >
            <template v-slot:items="props">
                <td hidden
                v-model="props.item.id">
                    {{ props.item.id }}</td>
                <td class="text-xs-left">{{ props.item.name }}</td>
                <td class="text-xs-left">{{ props.item.provider }}</td>
                <td class="text-xs-left">{{ props.item.price }}</td>
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
                            <v-btn fab dark small color="pink">
                    <v-icon @click="addToCart(option, props.item)"dark>add_shopping_cart</v-icon>
                            </v-btn>
                        </td>
                    </tr>
                </td>
            </template>
        </v-data-table>
        <div class="text-xs-center pt-2">
            <v-pagination v-model="pagination.page" :length="pages"></v-pagination>
        </div>
    </v-card>
</template>
<!--{-->
<!--text: 'id',-->
<!--align: 'left',-->
<!--sortable: false,-->
<!--value: 'id'-->
<!--},-->
<script>
    import shopService from '../../services/ShopService'
    import { mapGetters, mapActions } from 'vuex'
    export default {
        data () {
            return {
                goods:[],
                totalItmes: 50,
                pagination: {
                    descending: true,
                    page: 1,
                    rowsPerPage: 10,
                    totalItems: 50
                },
                subheaders: ['색상', '사이즈'],
                headers: [
                    {text: '상품명', value: 'name', sortable: false, align: 'left'},
                    {text: '등록자', value: 'provider', sortable: false, align: 'left'},
                    {text: '가격', value: 'price', sortable: false, align: 'left'},
                    {text: '담기', sortable: false, align: 'left'}
                ],
            }
        },
        watch: {
            pagination: {
                handler () {
                    console.log(this.pagination);
                    if (this.pagination) {
                        console.log("111");
                    }else {
                        console.log("222");
                    }
                    console.log("watch page!!!");
                    this.updatePagination(this.pagination);
                },
                deep: true
            }
        },
        computed: {
            itemsInCart(){
                let cart = this.$store.getters.cartItem;
                console.log("cart", cart);
                return cart;
                // let cart = this.$store.mapGetters['cartItem'];
                // console.log("getCart",cart);
                // return cart.reduce((accum, item) => accum + item.quantity, 0)
            },
            pages () {
                console.log("page show", this.pagination);
                if (this.pagination.rowsPerPage == null ||
                    this.pagination.totalItems == null
                ) return 0

                return Math.ceil(this.pagination.totalItems / this.pagination.rowsPerPage)
            }
        },
        methods: {
            addToCart(option, item) {
                console.log("addToCart",item);
                this.$store.dispatch('addToCart',option.id);
                var param = {
                    optionId : option.id,
                    goodsId : item.id,
                    quantity : 1,
                    userId: 1
                }
                shopService.addCart(param).then(data => {
                    console.log("data->>>>>>>", data);
                })
                alert("장바구니에 담았습니다.")

            },
            updatePagination (pagination) {
                var param = {
                    page : pagination.page,
                    size: 10
                }
                shopService.getProductList(param).then(data => {
                    if (data) {
                        console.log("-------------------");
                        console.log(data);
                        console.log(data.goods);
                        this.goods = data.goods;
                        this.$store.dispatch('setCartList', data.goods);
                        this.pagination['totalItems'] = data.totalElement;
                    }
                })
            },
        }
    }
</script>

