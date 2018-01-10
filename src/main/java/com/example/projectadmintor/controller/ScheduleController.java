package com.example.projectadmintor.controller;

import com.example.projectadmintor.bean.Schedule;
import com.example.projectadmintor.mapper.ScheduleMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @PostMapping("/insertschedule")
    public String insertSchedule(Schedule schedule, HttpServletRequest request){
        schedule.setScheduleid(request.getParameter("scheduleid"));
        schedule.setProjectid(request.getParameter("projectid"));
        schedule.setMemberid(request.getParameter("memberid"));
        schedule.setDescription(request.getParameter("description"));
        schedule.setDeadline(request.getParameter("deadline"));
        schedule.setCompletestate(request.getParameter("completestate"));
        int result=scheduleMapper.insertSchedule(schedule);
        if(result>0)
            return "success";
        else
            return "fail";
    }

    @PostMapping("/selectschedules")
    public String  selectSchedules(HttpServletRequest request){
        List<Schedule> schedules= scheduleMapper.selectSchedules(request.getParameter("projectid"),request.getParameter("studentid"));
        return new Gson().toJson(schedules);
    }

    @PostMapping("/updateschedule")
    public String updateSchedule(HttpServletRequest request){
        scheduleMapper.updateSchedule(request.getParameter("scheduleid"),request.getParameter("completestate"));
        return "success";
    }
}
