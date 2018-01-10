package com.example.projectadmintor.controller;

import com.example.projectadmintor.bean.Material;
import com.example.projectadmintor.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialMapper materialMapper;

    @PostMapping("/upload")
    public String uploadMaterial(Material material, HttpServletRequest request){
        String attachmentName="";
        try{
            MultipartFile attachmentFile=((MultipartHttpServletRequest)request).getFile("filename");
            String uploadDir=request.getSession().getServletContext().getRealPath("/upload");
            String fileName=System.currentTimeMillis()+"";
            InputStream stream=attachmentFile.getInputStream();
            String attachmentOriginName=attachmentFile.getOriginalFilename();
            String fileFormat=attachmentOriginName.substring(attachmentOriginName.lastIndexOf(".")+1,attachmentOriginName.length());
            attachmentName=fileName+"."+fileFormat;

            File dirPath=new File(uploadDir);
            if(!dirPath.exists()){
                dirPath.mkdir();
            }

            OutputStream bos=null;
            try{
                bos=new FileOutputStream(uploadDir+"/"+attachmentName);
                int bytesRead;
                byte[] buffer=new byte[8192];
                while ((bytesRead=stream.read(buffer,0,8192))!=-1){
                    bos.write(buffer,0,bytesRead);
                }
            }finally {
                if(bos!=null){
                    bos.close();
                }
                if(stream!=null){
                    stream.close();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        material.setMaterialid(request.getParameter("materialid"));
        material.setProjectid(request.getParameter("projectid"));
        material.setPicture(request.getParameter("picture"));
        int result = materialMapper.insertMaterial(material);
        if(result>0)
            return "success";
        else
            return "fail";
    }
}
