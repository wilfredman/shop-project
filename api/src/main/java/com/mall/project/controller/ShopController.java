package com.mall.project.controller;

import com.mall.project.domain.Cart;
import com.mall.project.domain.Goods;
import com.mall.project.domain.InitEntity;
import com.mall.project.domain.Options;
import com.mall.project.domain.Shipping;
import com.mall.project.service.ShopService;
import com.mall.project.util.JsonFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class ShopController {

    private final ShopService shopService;

    @GetMapping("products")
    public Page<Goods> getProducts(final Pageable pageable) {
        return shopService.getAllProducts(pageable);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Goods> getProductById(@PathVariable("id") Integer id) {
        Goods goods = shopService.getProducById(id);
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }

    @PostMapping("cart")
    public ResponseEntity<Cart> cartSave(@RequestParam Goods pid,
                                         @RequestParam Options id,
                                         @RequestParam Integer cnt) {
        Cart cart = new Cart(pid, id, cnt);
        long cs = shopService.cartSave(cart);
        if (cs == 0L) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping("product")
    public ResponseEntity<Void> addProducts() throws IOException {
        JsonFormat jsonFormat = new JsonFormat();
        InitEntity entity = jsonFormat.dummyPush();

        try {
            for (InitEntity.Goods e : entity.getGoods()) {
                Goods goods = new Goods(e.getName(), e.getProvider(), e.getPrice());
                long gs = shopService.goodsSave(goods);
                if (gs == 0L) return new ResponseEntity<>(HttpStatus.CONFLICT);

                for (InitEntity.Goods.Options o : e.getOptions()) {
                    String getId = String.valueOf(o.getId());
                    Options options = new Options(getId, e.getId(), o.getColor(), o.getSize(), o.getStock());
                    long os = shopService.optionsSave(options);
                    if (os == 0L) return new ResponseEntity<>(HttpStatus.CONFLICT);
                }

                InitEntity.Goods.Shipping s = e.getShipping();
                Shipping shipping = new Shipping(e.getId(), s.getMethod(), s.getPrice(), s.isCanBundle());
                long ss = shopService.shippingSave(shipping);
                if (ss == 0L) return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
