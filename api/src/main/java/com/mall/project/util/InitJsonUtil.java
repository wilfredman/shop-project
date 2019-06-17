package com.mall.project.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.project.dto.InitEntity;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by jhtip82@gmail.com on 2019-06-14
 * Github : http://github.com/jhtip
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class InitJsonUtil {
    private final static String jsonFile = "/shopRequest.json";

    public InitEntity shopItemsPush() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(
                new ClassPathResource(jsonFile).getFile(), InitEntity.class);
    }
}
