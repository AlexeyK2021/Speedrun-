package com.tea.blendingsystem.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Param {

    private String name;
    private float value;
    private int equip_id;
    private Equipment equipment;

    public Param(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public Param(ResultSet rs) {
        try {
            this.name = rs.getString("name_cur_param");
            this.value = rs.getFloat("value_cur_param");
            this.equip_id = rs.getInt("equip_id");
//            this.equip_id = rs.getFloat("value_ref_equip");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getEquip_id() {
        return equip_id;
    }

    public void setEquip_id(int equip_id) {
        this.equip_id = equip_id;
    }

    @Override
    public String toString() {
        return "Param{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", equip_id=" + equip_id +
                ", equipment=" + equipment +
                '}';
    }
}
