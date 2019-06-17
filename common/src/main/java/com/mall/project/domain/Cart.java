package com.mall.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Data
@Entity
@NoArgsConstructor
public class Cart {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private int opt_cnt;
    @Column
    private Long goods_id;
    @Column
    private Long options_id;

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "goods_id")
    private Collection<Goods> goods;

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "options_id")
    private Collection<Options> options;

    public Cart(Long goods_id, Long options_id, int opt_cnt) {
        this.goods_id = goods_id;
        this.options_id = options_id;
        this.opt_cnt = opt_cnt;
    }
}
