package com.example.projectadmintor.mapper;

import com.example.projectadmintor.bean.SignInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SignMapper {
    @Insert("insert into sign_info(signid,memberid,projectid,signdate) VALUE(#{signid},#{memberid},#{projectid},#{signdate})")
    int insertSignInfo(SignInfo signInfo);

    @Select("select * from sign_info where projectid=#{projectid} and memberid=#{studentid}")
    List<SignInfo> selectSignInfo(@Param("projectid") String projectid,@Param("studentid") String studentid);
}
