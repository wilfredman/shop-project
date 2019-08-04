package com.mall.project.controller;

import com.mall.project.domain.Cart;
import com.mall.project.dto.CartDto;
import com.mall.project.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 장바구니 정보를 추가,삭제,조회
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("cart")
    public List<Cart> getCarts(CartDto.CartListRequest request) {
        return cartService.getAllCarts(request);
    }

    @PostMapping("cart")
    public Cart cartSave(CartDto.CartAddRequest request) {
        return cartService.cartSave(request);
    }

    @DeleteMapping("cart")
    public void deleteCarts(CartDto.CartDeleteRequest request) {
        cartService.deleteCarts(request);
    }

}
