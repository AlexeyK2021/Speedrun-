package com.tea.blendingsystem.models;

import java.sql.ResultSet;

public class Deviation {
    private float value_dev;
    private int param_id;

    public Deviation(ResultSet rs) {
        try {
            value_dev = rs.getFloat("value_dev");
            param_id = rs.getInt("cur_param_id");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public float getValue_dev() {
        return value_dev;
    }

    public void setValue_dev(float value_dev) {
        this.value_dev = value_dev;
    }

    public int getParam_id() {
        return param_id;
    }

    public void setParam_id(int param_id) {
        this.param_id = param_id;
    }

    @Override
    public String toString() {
        return "Deviation{" +
                "value_dev=" + value_dev +
                ", param_id=" + param_id +
                '}';
    }
}
