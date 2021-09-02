package com.earthquake.managementPlatform.mapper;

import com.earthquake.managementPlatform.entities.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ScheduleMapper {

    @Select("SELECT cron FROM earthquakebackup.schedule;")
    String getSchedule();

    @Update("UPDATE `earthquakebackup`.`schedule` SET `cron` = #{cron} WHERE (`id` = #{id});")
    int updateSchedule(Schedule schedule);
}
