package com.tea.blendingsystem.models;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;

public class Equipment {
    private String name;
    private String serialNum;

    public Equipment(String name, String serialNum) {
        this.name = name;
        this.serialNum = serialNum;
    }

    public Equipment(ResultSet rs) {
        try {
            name = rs.getString("name_equip");
            serialNum = rs.getString("serial_num_equip");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", serialNum='" + serialNum + '\'' +
                '}';
    }
}
