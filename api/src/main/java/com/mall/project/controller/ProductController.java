package com.mall.project.controller;

import com.mall.project.domain.*;
import com.mall.project.dto.ProductDto;
import com.mall.project.dto.ProductDto.ProductListResponse;
import com.mall.project.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("products")
    public ProductListResponse getProducts(ProductDto.ProductListRequest request) {
        return productService.getAllProducts(request);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Goods> getProductById(@PathVariable("id") Integer id) {
        Goods goods = productService.getProducById(id);
        return new ResponseEntity<>(goods, HttpStatus.OK);
    }
}
