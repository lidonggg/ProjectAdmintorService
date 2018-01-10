package com.example.projectadmintor.controller;

import com.example.projectadmintor.bean.Member;
import com.example.projectadmintor.bean.Project;
import com.example.projectadmintor.bean.Project_member;
import com.example.projectadmintor.mapper.ProjectMapper;
import com.example.projectadmintor.model.ProjectMember;
import com.example.projectadmintor.model.StudentProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectMapper projectMapper;

    @PostMapping("/insertproject")
    public String insertProject(Project project, HttpServletRequest request){
        project.setProject_id(request.getParameter("projectid"));
        project.setProjectname(request.getParameter("projectname"));
        project.setDescription(request.getParameter("description"));
        project.setFunds(request.getParameter("funds"));
        project.setStartdate(request.getParameter("startdate"));
        project.setEnddate(request.getParameter("enddate"));
        projectMapper.insertProjectProperties(project);
        return "success";
    }

    @PostMapping("/insertmember")
    public String insertMember(Member member,HttpServletRequest request){
        member.setMemberid(request.getParameter("memberid"));
        member.setName(request.getParameter("name"));
        member.setMajor(request.getParameter("major"));
        member.setGrade(request.getParameter("grade"));
        projectMapper.insertProjectMembers(member);
        return "success";
    }

    @PostMapping("/insertrelation")
    public String insertRalation(Project_member project_member,HttpServletRequest request){
        project_member.setProjectid(request.getParameter("projectid"));
        project_member.setMemberid(request.getParameter("memberid"));
        projectMapper.insertRelation(project_member);
        projectMapper.insertRelationSP(project_member);
        return "success";
    }

    @PostMapping("/selectproject")
    public List<StudentProject> selectProjectByStudent(HttpServletRequest request){
        return projectMapper.selectProjectByStudent(request.getParameter("studentid"));
    }

    @PostMapping("/selectmember")
    public List<ProjectMember> selectProjectMembers(HttpServletRequest request){
        return projectMapper.selectProjectMembers(request.getParameter("projectid"));
    }
}
