package com.example.projectadmintor.mapper;

import com.example.projectadmintor.bean.Schedule;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ScheduleMapper {
    @Insert("insert into schedule(scheduleid,projectid,memberid,description,deadline,completestate) " +
            "VALUE(#{scheduleid},#{projectid},#{memberid},#{description},#{deadline},#{completestate})")
    int insertSchedule(Schedule schedule);

    @Select("select * from schedule where projectid=#{projectid} and memberid=#{studentid}")
    List<Schedule> selectSchedules(@Param("projectid") String projectid,@Param("studentid") String studentid);

    @Update("update schedule set completestate=#{completestate} where scheduleid=#{scheduleid}")
    int updateSchedule(@Param("scheduleid") String scheduleid,@Param("completestate") String completestate);
}
