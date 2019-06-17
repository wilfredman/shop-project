import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    added: [],
    totalAmount:0,
    optionList:new Map(),
    selectedItemList:[],
    cartList: []
  },
  getters: {
    cartItem : state => {
      return state.added.length == 0 ? state.added.length : state.added.reduce((num,prop)=> num+prop.quantity,0);
    },
    totalAmount: state=> state.totalAmount,
    optionList: state=> state.optionList,
    selectedItemList: state=> state.selectedItemList,
    cartList: state => state.cartList
  },
  mutations: {
    addToCart(state, { id }) {
      const record = state.added.find(p => p.id === id)

      if (!record) {
        state.added.push({
          id,
          quantity: 1
        })
      } else {
        record.quantity++
      }
    },
    addTotalAmount(state, amount) {
      state.totalAmount += amount;
    },
    setTotalAmount(state, amount) {
      state.totalAmount = amount;
    },
    updateOptionFromCart(state, param) {
      let id = param['optionId'];
        if(state.optionList.has(id)) {
          state.optionList.delete(id);
        }else {
          state.optionList.set(id, param);
        }
      console.log("method result",state.optionList);
    },
    updateSelectedItemFromCart(state, index) {

      if(state.selectedItemList.includes(index)) {

        state.selectedItemList.splice(index, 1);
      } else {
        state.selectedItemList.push(index);
      }
    },
    deleteOptionList(state, id) {
      state.optionList.delete(id);
    },
    emptyAllCartList(state) {
      state.optionList = new Map();
      state.selectedItemList = [];

    },
    setCartList(state, list) {
      state.cartList = list;
    },
    removeCartListItem(state, index) {
      state.cartList.splice(index, 1);
    },
    removeCartNum(state, id) {
      console.log("remove---", id, state.added);
      let index = state.added.findIndex(p => p.id === id);
      console.log(index);
      state.added.splice(index,1);
    }
  },
  actions: {
    getCartProducts: state => {
      return state.added.map(({ id, quantity }) => {
        return {
          id: id,
          quantity: quantity
        }
      })
    },
    addToCart({ commit }, id){
      commit('addToCart', {
        id: id
      })
    },
    addTotalAmount({commit}, amount) {
      commit('addTotalAmount', amount)
    },
    setTotalAmount({commit}, amount) {
      commit('setTotalAmount', amount)
    },
    updateOptionFromCart({commit},param) {
      console.log("update!!!", param);
      commit('updateOptionFromCart', param)
    },
    updateSelectedItemFromCart({commit}, index) {
      commit('updateSelectedItemFromCart', index)
    },
    deleteOptionList({commit}, id) {
      commit('deleteOptionList', id)
    },
    emptyAllCartList({commit}) {
      commit('emptyAllCartList')
    },
    setCartList({commit}, list) {
      commit('setCartList', list)
    },
    removeCartListItem({commit}, index) {
      commit('removeCartListItem', index)
    },
    removeCartNum({commit}, id) {
      commit('removeCartNum', id)
    }
  }
})
