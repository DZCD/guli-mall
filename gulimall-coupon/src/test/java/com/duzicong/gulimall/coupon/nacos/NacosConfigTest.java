package com.duzicong.gulimall.coupon.nacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NacosConfigTest {

    @Value("${coupon.user.name}")
    private String name;
    @Value("${coupon.user.age}")
    private String age;

    @Test
    void loadConfig(){
        System.out.println(name);
        System.out.println(age);
    }
}
