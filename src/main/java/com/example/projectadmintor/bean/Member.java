package com.example.projectadmintor.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Member {
    private String memberid;
    private String name;
    private String major;
    private String grade;

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String member_id) {
        this.memberid = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
