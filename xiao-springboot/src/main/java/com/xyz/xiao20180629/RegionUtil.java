package com.xyz.xiao20180629;

import com.google.common.base.Splitter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegionUtil {


    private Map<Integer, Region> cityCodeKeyRegionMap = new HashMap();

    public Region getRegionByCityCode(Integer cityCode) {
        return cityCodeKeyRegionMap.get(cityCode);
    }

    public void setRegionMsg(String regionMsg) {
        List<String> regionList = Splitter.on("@@").splitToList(regionMsg);
        for (int i = 0; i < regionList.size(); i++) {
            if (i % 3 == 0) {
                int cityCode = Integer.parseInt(regionList.get(i));
                int upCode = Integer.parseInt(regionList.get(i + 2));
                String name = regionList.get(i + 1);
                cityCodeKeyRegionMap.put(cityCode, new Region(cityCode, upCode, name));
            }
        }
    }
}
