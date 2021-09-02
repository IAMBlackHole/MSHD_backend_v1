package com.earthquake.managementPlatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CrackRecordMapper {
    @Select("SELECT max(ID) FROM earthquake.crackrecord WHERE ID like concat(#{adminCateId},'%') FOR UPDATE")
    String getSomeCrackRecordByACId(String adminCateId);
}
