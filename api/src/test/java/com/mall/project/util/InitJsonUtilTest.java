package com.mall.project.util;

import com.mall.project.dto.InitEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InitJsonUtilTest {

    @Autowired
    private InitJsonUtil initJsonUtil;

    @Test
    public void dummyPushTest() throws IOException {
        InitEntity init = initJsonUtil.shopItemsPush();
        System.out.println(init.toString());
    }
}
