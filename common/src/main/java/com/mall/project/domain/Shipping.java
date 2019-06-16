package com.mall.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Data
@Entity
@NoArgsConstructor
public class Shipping {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long goods_id;
    @Column
    private String method;
    @Column
    private long price;
    @Column
    private boolean canBundle;

    public Shipping(Long goods_id, String method, long price, boolean canBundle) {
        this.goods_id = goods_id;
        this.method = method;
        this.price = price;
        this.canBundle = canBundle;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "id=" + id +
                ", goods_id=" + "" +
                ", method='" + method + '\'' +
                ", price=" + price +
                ", canBundle=" + canBundle +
                '}';
    }
}
