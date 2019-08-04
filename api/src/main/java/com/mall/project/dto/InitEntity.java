package com.mall.project.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 상품정보, 상품옵션, 배송정보 JPA Entity
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Data
@ToString
public class InitEntity {
    private List<Goods> goods;

    @Data
    @RequiredArgsConstructor
    public static class Goods {
        private Long id;
        private String name;
        private String provider;
        private long price;
        private List<Options> options;
        private Shipping shipping;

        @Data
        public static class Options {
            private Long id;
            private Long goods_id;
            private String color;
            private String size;
            private int stock;
        }

        @Data
        public static class Shipping {
            private Long id;
            private Long goods_id;
            private String method;
            private long price;
            private boolean canBundle;
        }
    }
}
