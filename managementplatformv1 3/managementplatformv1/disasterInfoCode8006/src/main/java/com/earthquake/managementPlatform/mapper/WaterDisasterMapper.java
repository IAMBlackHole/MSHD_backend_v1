package com.earthquake.managementPlatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WaterDisasterMapper {
    @Select("SELECT max(ID) FROM earthquake.waterdisaster WHERE ID like concat(#{adminCateId},'%') FOR UPDATE")
    public String getSomeWaterDisasterByACId(String adminCateId);
}
