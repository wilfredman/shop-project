import Api from './Api'

const urlLists = {
    productList : '/products',
    addCart: '/cart',
    removeCart: '/cart',
    cartList: '/cart'
}

export default {
    getProductList(param) {
        return Api.get(urlLists.productList, param);
    },
    addCart(param) {
        return Api.post(urlLists.addCart, param);
    },
    removeCart(param) {
        return Api.delete(urlLists.removeCart, param);
    },
    getCartList(param) {
        return Api.get(urlLists.cartList, param);
    }

}
