package com.example.projectadmintor.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public class Project {
    private String projectid;

    private String projectname;
    private String description;
    private String funds;
    private String startdate;
    private String enddate;

    public String getProjectid() {
        return projectid;
    }

    public void setProject_id(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String project_name) {
        this.projectname = project_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String start_date) {
        this.startdate = start_date;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String end_date) {
        this.enddate = end_date;
    }
}
