package com.xyz.xiao20180629;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:regions.properties")
public class LoadRegion {

    @Value("${regions_str}")
    private String regionMsg;

    @Bean
    public RegionUtil regionUtil() {
        RegionUtil regionUtil = new RegionUtil();
        regionUtil.setRegionMsg(regionMsg);
        return regionUtil;
    }

}
