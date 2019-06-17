package com.mall.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Options {
    @Id
    @Column
    private Long id;
    @Column
    private String color;
    @Column
    private String size;
    @Column
    private int stock;
    @Column
    private Long goods_id;
}
