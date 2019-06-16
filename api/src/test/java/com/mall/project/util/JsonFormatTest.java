package com.mall.project.util;

import com.mall.project.domain.InitEntity;

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
public class JsonFormatTest {

    @Autowired
    private JsonFormat jsonFormat;

    @Test
    public void dummyPushTest() throws IOException {

        InitEntity init = jsonFormat.dummyPush();
        System.out.println(init.toString());

    }
}
