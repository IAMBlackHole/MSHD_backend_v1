package com.earthquake.managementPlatform.mapper;

import com.earthquake.managementPlatform.entities.CommDisaster;
import com.earthquake.managementPlatform.entities.SecondaryDisasterStatistics;
import com.earthquake.managementPlatform.entities.CrackRecord;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface CrackRecordMapper {
    @Select("SELECT * FROM earthquake.crackrecord;")
    @Results(id="crackRecordMap", value={
            @Result(column="ID", property="id", jdbcType= JdbcType.CHAR, id=true),
            @Result(column="date", property="date", jdbcType= JdbcType.VARCHAR),
            @Result(column="location", property="location", jdbcType= JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType= JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType= JdbcType.VARCHAR),
            @Result(column="picture", property="picture", jdbcType= JdbcType.VARCHAR),
            @Result(column="note", property="note", jdbcType= JdbcType.VARCHAR),
            @Result(column="reporting_unit", property="reportingUnit", jdbcType= JdbcType.VARCHAR),
            @Result(column="earthquake_id", property="earthquakeId", jdbcType= JdbcType.CHAR)
    })
    List<CrackRecord> getAllCrackRecord();

    @Select("select * from earthquake.crackrecord order by date desc limit #{pageNum}, #{limit};")
    @ResultMap(value = "crackRecordMap")
    List<CrackRecord> getCrackRecordByPage(@Param("pageNum") int pageNum, @Param("limit")int limit);

    @Select("select * from earthquake.crackrecord where date >=  NOW() - interval #{time} hour order by date desc;")
    @ResultMap(value = "crackRecordMap")
    List<CrackRecord> getRecentCrackRecord(@Param("time") int time );

    @Select("select * from earthquake.crackrecord where date >=  NOW() - interval #{time} hour order by date desc limit #{pageNum}, #{limit};")
    @ResultMap(value = "crackRecordMap")
    List<CrackRecord> getRecentCrackRecordByPage(@Param("pageNum") int pageNum,@Param("limit")int limit,@Param("time") int time );

    @Select("SELECT * FROM earthquake.crackrecord WHERE ID = #{id} FOR UPDATE")
    @ResultMap(value = "crackRecordMap")
    CrackRecord getCrackRecordById(String id);

//    @Select("SELECT max(ID) FROM earthquake.disasterinfo WHERE ID like concat(#{adminCateId},'%') FOR UPDATE")
//    public String getSomeDisasterInfoByACId(String adminCateId);

    @Insert("INSERT INTO `earthquake`.`crackrecord` (`ID`, `date`, `location`, `type`, `status`, `picture`, `note`, `reporting_unit`, `earthquake_id`) VALUES (#{id},#{date},#{location},#{type},#{status},#{picture},#{note},#{reportingUnit},#{earthquakeId})")
    int save(CrackRecord crackRecord);

    @Update("UPDATE `earthquake`.`crackrecord` SET `date`=#{date}, `location`=#{location}, `type`=#{type}, `status`=#{status}, `picture`=#{picture}, `note`=#{note},`reporting_unit`=#{reportingUnit},`earthquake_id`=#{earthquakeId} WHERE `ID`=#{id}")
    int update(CrackRecord crackRecord);

    @Delete("DELETE FROM `earthquake`.`crackrecord` WHERE ID = #{id}")
    int deleteById(String id);

    @Select("SELECT ID FROM earthquake.crackrecord order by date desc limit 1 FOR UPDATE")
    String getNewCode();

    @Select("SELECT * FROM earthquake.crackrecord order by date desc limit 1 FOR UPDATE")
    @ResultMap(value = "crackRecordMap")
    CrackRecord getNewCodeDescription();

    @Select("SELECT * FROM earthquake.lastcrackrecord")
    @Results(id="secondaryDisasterStatisticsMap", value={
            @Result(column="status", property="status", jdbcType= JdbcType.VARCHAR),
            @Result(column="count", property="count", jdbcType= JdbcType.INTEGER),
    })
    List<SecondaryDisasterStatistics> getCrackStatistics();

    @Select("select * from earthquake.crackrecord where date <  NOW() - interval #{time} hour;")
    @ResultMap(value = "crackRecordMap")
    List<CrackRecord> getCopyCrackRecord(@Param("time") int time);
}
