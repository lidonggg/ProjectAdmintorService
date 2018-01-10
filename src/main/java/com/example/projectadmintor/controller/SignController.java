package com.example.projectadmintor.controller;

import com.example.projectadmintor.bean.SignInfo;
import com.example.projectadmintor.mapper.SignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/sign")
public class SignController {
    @Autowired
    private SignMapper signMapper;

    @PostMapping("/insertsigninfo")
    public String insertSignInfo(SignInfo signInfo,HttpServletRequest request){
        signInfo.setSignid(request.getParameter("signid"));
        signInfo.setProjectid(request.getParameter("projectid"));
        signInfo.setMemberid(request.getParameter("studentid"));
        signInfo.setSigndate(request.getParameter("signdate"));
        int result=signMapper.insertSignInfo(signInfo);
        if(result>0)
            return "success";
        else
            return "fail";
    }

    @PostMapping("/getsigninfo")
    public List<SignInfo> getSignInfo(HttpServletRequest request){
        return signMapper.selectSignInfo(request.getParameter("projectid"),request.getParameter("studentid"));
    }
}
