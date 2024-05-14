package com.tea.blendingsystem.models;

import java.sql.ResultSet;

public class LogType {
    private String name_log;
    private String describe_log;

    public LogType(String name_log, String describe_log) {
        this.name_log = name_log;
        this.describe_log = describe_log;
    }

    public LogType(ResultSet rs) {
        try{
            name_log = rs.getString("name_log");
            describe_log = rs.getString("describe_log");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName_log() {
        return name_log;
    }

    public void setName_log(String name_log) {
        this.name_log = name_log;
    }

    public String getDescribe_log() {
        return describe_log;
    }

    public void setDescribe_log(String describe_log) {
        this.describe_log = describe_log;
    }

}
