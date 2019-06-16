package com.mall.project.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * Created by jhtip82@gmail.com on 2019-06-15
 * Github : http://github.com/jhtip
 */
public class IdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        int id = 1; // getGoodsId
        int cnt = 1;
        String suffix = String.format("%03d", cnt++);
        String generatedId = new Integer(id).toString() + suffix;
        return generatedId;
    }
}
