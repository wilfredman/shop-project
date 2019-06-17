package com.mall.project.service;

import com.mall.project.domain.Goods;
import com.mall.project.domain.Options;
import com.mall.project.dto.InitEntity;
import com.mall.project.domain.Shipping;
import com.mall.project.repository.CartRepository;
import com.mall.project.repository.GoodsRepository;
import com.mall.project.repository.OptionsRepository;
import com.mall.project.repository.ShippingRepository;
import com.mall.project.util.InitJsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.PostLoad;

@Slf4j
@RequiredArgsConstructor
@Component
public class InitService {

    private final GoodsRepository goodsRepository;
    private final OptionsRepository optionsRepository;
    private final ShippingRepository shippingRepository;

    @PostLoad
    @PostConstruct
    private void init() {
        InitJsonUtil initJsonUtil = new InitJsonUtil();
        try {
            InitEntity entity = initJsonUtil.shopItemsPush();


            entity.getGoods().stream().forEach(goods->{
                goodsRepository.save(makeGoods(goods));
                shippingRepository.save(makeShipping(goods.getId(), goods.getShipping()));

                goods.getOptions().forEach(options-> {
                    optionsRepository.save(makeOption(goods.getId(), options));

                });
            });

        } catch (Exception e) {
            log.error("InitDb -> {} ", e.getMessage());
        }
    }

    private Shipping makeShipping(Long goodsId, InitEntity.Goods.Shipping shipping) {
        return Shipping.builder().goods_id(goodsId).method(shipping.getMethod()).price(shipping.getPrice()).canBundle(shipping.isCanBundle()).build();
    }

    private Options makeOption(Long goodsId, InitEntity.Goods.Options options) {
        return Options.builder().id(options.getId()).goods_id(goodsId).color(options.getColor()).size(options.getSize()).stock(options.getStock()).build();
    }

    private Goods makeGoods(InitEntity.Goods goods) {
        return Goods.builder().name(goods.getName()).provider(goods.getProvider()).price(goods.getPrice()).id(goods.getId()).build();
    }
}
