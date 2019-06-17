package com.mall.project.service;

import com.mall.project.domain.Cart;
import com.mall.project.domain.Goods;
import com.mall.project.domain.Shipping;
import com.mall.project.domain.Options;
import com.mall.project.repository.CartRepository;
import com.mall.project.repository.GoodsRepository;
import com.mall.project.repository.OptionsRepository;
import com.mall.project.repository.ShippingRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Service
@AllArgsConstructor
public class ShopService {
    private GoodsRepository goodsRepository;
    private OptionsRepository optionsRepository;
    private ShippingRepository shippingRepository;
    private CartRepository cartRepository;

    public Long goodsSave(Goods goods) {
        return goodsRepository.save(goods).getId();
    }

    public Long optionsSave(Options options) {
        return optionsRepository.save(options).getId();
    }

    public Long shippingSave(Shipping shipping) {
        return shippingRepository.save(shipping).getId();
    }

    public Page<Goods> getAllProducts(Pageable pageable) {
        return goodsRepository.findAll(pageable);
    }

    public Goods getProducById(long id) {
        Goods obj = goodsRepository.findById(id).get();
        return obj;
    }

    public List<Cart> getAllCarts() {
        List<Cart> list = new ArrayList<>();
        cartRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Long cartSave(Cart cart) {
        return cartRepository.save(cart).getId();
    }


}
