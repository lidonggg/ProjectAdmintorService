package com.example.projectadmintor.mapper;

import com.example.projectadmintor.bean.Material;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MaterialMapper {
    @Insert("insert into material(materialid,projectid,picture) VALUE(#{materialid},#{projectid},#{picture})")
    int insertMaterial(Material material);
}
