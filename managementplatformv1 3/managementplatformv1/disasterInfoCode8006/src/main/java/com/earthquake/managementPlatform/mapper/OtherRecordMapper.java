package com.earthquake.managementPlatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OtherRecordMapper {
    @Select("SELECT max(ID) FROM earthquake.otherrecord WHERE ID like concat(#{adminCateId},'%') FOR UPDATE")
    String getSomeOtherRecordByACId(String adminCateId);
}
