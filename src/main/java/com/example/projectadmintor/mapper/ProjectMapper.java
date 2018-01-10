package com.example.projectadmintor.mapper;

import com.example.projectadmintor.bean.Member;
import com.example.projectadmintor.bean.Project;
import com.example.projectadmintor.bean.Project_member;
import com.example.projectadmintor.model.ProjectMember;
import com.example.projectadmintor.model.StudentProject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectMapper {
    @Insert("insert into project(projectid,projectname,funds,description,startdate,enddate) " +
            "VALUE(#{projectid},#{projectname},#{funds},#{description},#{startdate},#{enddate})")
    int insertProjectProperties(Project project);

    @Insert("insert into member(memberid,name,major,grade) VALUE(#{memberid},#{name},#{major},#{grade})")
    int insertProjectMembers(Member member);

    @Insert("insert into project_member(projectid,memberid) VALUE(#{projectid},#{memberid});")
    int insertRelation(Project_member project_member);

    @Insert("insert into student_project(studentid,projectid) value(#{memberid},#{projectid})")
    int insertRelationSP(Project_member project_member);

    @Select("select * from student_project natural join project where studentid=#{studentid}")
    List<StudentProject> selectProjectByStudent(@Param("studentid") String studentid);

    @Select("select * from project_member natural join member where projectid=#{projectid}")
    List<ProjectMember> selectProjectMembers(@Param("projectid") String projectid);
}
