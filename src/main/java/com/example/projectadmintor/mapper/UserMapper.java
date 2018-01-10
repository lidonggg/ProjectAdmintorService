package com.example.projectadmintor.mapper;

import com.example.projectadmintor.bean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    @Insert("insert into student(studentid,username,password,identity) VALUE(#{studentid},#{username},#{password},#{identity})")
    int insertStudent(Student student);

    @Select("select * from student where username=#{username}")
    Student selectByName(@Param("username") String username);

    @Select("select * from student")
    List<Student> selectAllStudent();

    @Select("select * from student where studentid=#{studentid}")
    Student selectById(@Param("studentid") String studentid);
}
