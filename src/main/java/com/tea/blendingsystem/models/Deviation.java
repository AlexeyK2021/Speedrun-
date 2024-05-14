package com.tea.blendingsystem.models;

import java.sql.ResultSet;

public class Deviation {
    private float value_dev;
    private int param_id;
    private Param currentParam;

    public Deviation(ResultSet rs) {
        try {
            value_dev = rs.getFloat("value_dev");
            param_id = rs.getInt("cur_param_id");
            currentParam = new Param(
                    rs.getString("name_cur_param"),
                    rs.getFloat("value_cur_param")
            );
            currentParam.setEquipment(new Equipment(
                    rs.getString("name_equip"),
                    rs.getString("serial_num_equip")));
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

    public Param getCurrentParam() {
        return currentParam;
    }

    public void setCurrentParam(Param currentParam) {
        this.currentParam = currentParam;
    }

    @Override
    public String toString() {
        return "Deviation{" +
                "value_dev=" + value_dev +
                ", param_id=" + param_id +
                ", current_param=" + currentParam +
                '}';
    }
}
