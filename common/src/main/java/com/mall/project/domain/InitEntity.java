package com.mall.project.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Data
@ToString
public class InitEntity {
    private List<Goods> goods;

    @Data
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

            @Override
            public String toString() {
                return "Options{" +
                        "id=" + id +
                        ", goods_id=" + goods_id +
                        ", color='" + color + '\'' +
                        ", size='" + size + '\'' +
                        ", stock=" + stock +
                        '}';
            }
        }

        @Data
        public static class Shipping {
            private Long id;
            private Long goods_id;
            private String method;
            private long price;
            private boolean canBundle;

            @Override
            public String toString() {
                return "Shipping{" +
                        "id=" + id +
                        ", goods_id=" + goods_id +
                        ", method='" + method + '\'' +
                        ", price=" + price +
                        ", canBundle=" + canBundle +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", provider='" + provider + '\'' +
                    ", price=" + price +
                    ", options=" + options +
                    ", shipping=" + shipping +
                    '}';
        }
    }

}
