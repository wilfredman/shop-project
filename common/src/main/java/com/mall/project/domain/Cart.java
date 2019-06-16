package com.mall.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

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

    @OneToOne
    @JoinTable(name = "goods",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Goods goods;

    @OneToOne
    @JoinTable(name = "options",
            joinColumns = @JoinColumn(name = "options_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Options options;

    public Cart(Goods goods, Options options, int opt_cnt) {
        this.goods = goods;
        this.options = options;
        this.opt_cnt = opt_cnt;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", goods=" + goods +
                ", options=" + options +
                '}';
    }
}
