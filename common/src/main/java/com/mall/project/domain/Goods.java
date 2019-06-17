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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Collection;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Data
@Entity
@NoArgsConstructor
public class Goods {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String provider;
    @Column
    private long price;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id")
    private Collection<Options> options;

    @OneToOne
    @JoinTable(name = "shipping",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id"))
    private Shipping shipping;

    @OneToMany
    @JoinTable(name = "cart",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "goods_id"))
    private Collection<Goods> goods;

    public Goods(String name, String provider, long price) {
        this.name = name;
        this.provider = provider;
        this.price = price;
    }

}
