package com.mall.project.repository;

import com.mall.project.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUserId(long userId);

    void deleteByOptionsIdAndUserId(long optionsId, long userId);
}

