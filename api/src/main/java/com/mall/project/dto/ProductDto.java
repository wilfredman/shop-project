package com.mall.project.dto;

import com.mall.project.domain.Goods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class ProductDto {
    @Data
    public static class ProductListRequest {
        private int page = 0;
        private int size = 10;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class ProductListResponse {
        private List<Goods> goods;
        private long page = 0;
        private long totalElement;
    }
}
