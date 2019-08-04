package com.mall.project.dto;

import lombok.Data;

import java.util.List;

/**
 * 장바구니정보 DTO
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
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
