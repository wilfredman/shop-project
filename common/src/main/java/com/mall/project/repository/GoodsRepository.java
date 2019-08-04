package com.mall.project.repository;

import com.mall.project.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 상품정보 JpaRepository interface
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
public interface GoodsRepository extends JpaRepository<Goods, Long> {}

