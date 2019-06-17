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
public class Options {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String color;
    @Column
    private String size;
    @Column
    private int stock;
    @Column
    private Long goods_id;

    public Options(Long id, Long goods_id, String color, String size, int stock) {
        this.id = id;
        this.goods_id = goods_id;
        this.color = color;
        this.size = size;
        this.stock = stock;
    }

}
