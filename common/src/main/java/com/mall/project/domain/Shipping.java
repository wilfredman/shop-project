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
}
