package com.example.projectadmintor.controller;

import com.example.projectadmintor.bean.Student;
import com.example.projectadmintor.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/insertstudent")
    public String insertStudent(Student student, HttpServletRequest request){
        student.setStudentid(request.getParameter("studentid"));
        student.setUsername(request.getParameter("username"));
        student.setPassword(request.getParameter("password"));
        student.setIdentity(request.getParameter("identity"));
        int insertResult = userMapper.insertStudent(student);
        if(insertResult>0){
            return "success";
        }
        else {
            return "fail";
        }
    }

    @PostMapping("/getbyid")
    public Student getStudentById(HttpServletRequest request){
        return userMapper.selectById(request.getParameter("studentid"));
    }

    @PostMapping("/getbyname")
    public Student getStudentByname(HttpServletRequest request){
        return userMapper.selectByName(request.getParameter("username"));
    }

    @PostMapping("/getalluser")
    public List<Student> getAllUser(){
        return userMapper.selectAllStudent();
    }
}
