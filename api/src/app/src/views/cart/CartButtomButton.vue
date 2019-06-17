<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <div class="text-xs-right pt-4 font-weight-medium">
    <v-dialog
            v-model="dialog"
            width="500"
    >
      <template v-slot:activator="{ on }">
        <v-btn
                dark
                v-on="on"
                class="white--text"
                color="info"
                @click="purchaseItem">
          선택된 목록 구매
        </v-btn>
      </template>

      <v-card>
        <v-card-title
                class="headline grey lighten-2"
                primary-title
        >
          구매
        </v-card-title>

        <v-card-text>
          구매 완료 했습니다.
        </v-card-text>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
                  color="primary"
                  flat
                  @click="acceptPurchase"
          >
            확인
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <v-btn dark
           class="white--text"
           color="info"
           @click="removeSelectedItems">
      선택된 목록 삭제
    </v-btn>

  </div>
</template>

<script>
  import HelloWorld from '../../components/HelloWorld'
  import shopService from '../../services/ShopService'
  export default {
    data() {
      return {
        dialog: false
      }
    },
    components: {
      HelloWorld
    },
    methods: {
      purchaseItem() {
        console.log("purchaseItems");
        let length = this.$store.getters.selectedItemList.length;
        if (length == 0) return;

      },
      removeSelectedItems() {

        let selectedItemList = this.$store.getters.selectedItemList;
        let length = selectedItemList.length;
        if (length == 0) return;
        for (let x =0; x < length ; x++) {
          this.$store.dispatch('removeCartListItem', selectedItemList[length-1-x]);
        }

        this.$store.dispatch('setTotalAmount', 0);
        let optionList = this.$store.getters.optionList;
        console.log("optionList", optionList);
        let optionId = [];

        optionList.forEach(option => {
                  this.$store.dispatch('removeCartNum', option.optionId);
                  optionId.push(option.optionId);
                }
        );

        let idList = optionId.join(",");
        let param = {
          optionIds : idList,
          userId:1
        };
        shopService.removeCart(param)
        this.$store.dispatch('emptyAllCartList');
      },
      acceptPurchase() {
        this.removeSelectedItems();
        this.dialog = false;
      }
    }
  }
</script>
