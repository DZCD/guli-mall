package com.duzicong.gulimall.product;

import com.duzicong.gulimall.product.entity.BrandEntity;
import com.duzicong.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Test
    void contextLoads() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandEntity.setLogo("https://guli-mall.oss-cn-shanghai.aliyuncs.com/huawei.png");
        brandEntity.setDescript("华为消费者业务致力于为消费者打造全场景智慧生活体验,产品覆盖手机、平板、电脑、手表等");
        brandEntity.setShowStatus(1);
        brandEntity.setFirstLetter("H");
        brandEntity.setSort(0);

        brandService.save(brandEntity);
        System.out.println("保存成功...");

    }

}
