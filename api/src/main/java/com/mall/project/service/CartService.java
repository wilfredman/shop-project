package com.mall.project.service;

import com.mall.project.domain.Cart;
import com.mall.project.domain.Goods;
import com.mall.project.domain.Options;
import com.mall.project.dto.CartDto;
import com.mall.project.repository.CartRepository;
import com.mall.project.repository.GoodsRepository;
import com.mall.project.repository.OptionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Service
@AllArgsConstructor
public class CartService {
    private CartRepository cartRepository;
    private GoodsRepository goodsRepository;
    private OptionsRepository optionsRepository;



    public List<Cart> getAllCarts(CartDto.CartListRequest request) {
        List<Cart> carts = cartRepository.findByUserId(request.getUserId());
        return carts;

    }

    public Cart cartSave(CartDto.CartAddRequest request) {
        Optional<Goods> good = goodsRepository.findById(request.getGoodsId());
        Optional<Options> option = optionsRepository.findById(request.getOptionId());
        if (!good.isPresent() || !option.isPresent()) new ResponseEntity<>(HttpStatus.BAD_REQUEST);;
        return cartRepository.save(makeCart(request,good.get(), option.get()));
    }

    private Cart makeCart(CartDto.CartAddRequest request, Goods goods, Options options) {

        return Cart.builder()
                .optCnt(request.getQuantity())
                .goods(goods)
                .options(options)
                .userId(request.getUserId())
                .build();
    }


    public void deleteCarts(CartDto.CartDeleteRequest request) {
        request.getOptionIds().stream().forEach(id->
                cartRepository.deleteByOptionsIdAndUserId(id, request.getUserId())
        );
    }
}
