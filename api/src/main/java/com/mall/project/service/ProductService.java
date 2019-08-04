package com.mall.project.service;

import com.mall.project.domain.Goods;
import com.mall.project.dto.ProductDto;
import com.mall.project.dto.ProductDto.ProductListResponse;
import com.mall.project.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * 상품 정보목록 조회 서비스
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Service
@AllArgsConstructor
public class ProductService {
    private GoodsRepository goodsRepository;
    //private CartRepository cartRepository;

    public ProductListResponse getAllProducts(ProductDto.ProductListRequest request) {
        int page = request.getPage() <= 0 ? 0 : request.getPage() - 1;
        Pageable pageable = PageRequest.of(page, request.getSize(), Sort.by("id").descending());
        Page<Goods> findResult = goodsRepository.findAll(pageable);
        return mapToProductResponse(findResult);
    }

    private ProductListResponse mapToProductResponse(Page<Goods> findResult) {
        return ProductListResponse.builder()
                .goods(findResult.getContent())
                .page(findResult.getPageable().getPageNumber())
                .totalElement(findResult.getTotalElements())
                .build();
    }

    public Goods getProducById(long id) {
        Goods obj = goodsRepository.findById(id).get();
        return obj;
    }

    /*public List<Cart> getAllCarts() {
        List<Cart> list = new ArrayList<>();
        cartRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public Long cartSave(Cart cart) {
        return cartRepository.save(cart).getId();
    }*/
}