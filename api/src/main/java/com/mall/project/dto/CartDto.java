package com.mall.project.dto;

import lombok.Data;

import java.util.List;

public class CartDto {
    @Data
    public static class CartAddRequest {
        private long goodsId;
        private long optionId;
        private int quantity;
        private int userId;
    }

    @Data
    public static class CartListRequest {
        private long userId;
    }

    @Data
    public static class CartDeleteRequest {
        private List<Long> optionIds;
        private long userId;
    }

}
