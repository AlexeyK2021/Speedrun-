package com.tea.blendingsystem.models;

import java.sql.ResultSet;

public class ReferenceParam {
    public int id_ref_equip;
    public String name_ref_equip;
    public String describe_ref_equip;
    public float value_ref_equip;
    public int type_param_id;
    public int supp_id;

    public ReferenceParam(ResultSet rs) {
        try{
            id_ref_equip = rs.getInt("id_ref_equip");
            name_ref_equip = rs.getString("name_ref_equip");
            describe_ref_equip = rs.getString("describe_ref_equip");
            value_ref_equip = rs.getFloat("value_ref_equip");
            type_param_id = rs.getInt("type_param_id");
            supp_id = rs.getInt("supp_id");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public int getId_ref_equip() {
        return id_ref_equip;
    }

    public void setId_ref_equip(int id_ref_equip) {
        this.id_ref_equip = id_ref_equip;
    }

    public String getName_ref_equip() {
        return name_ref_equip;
    }

    public void setName_ref_equip(String name_ref_equip) {
        this.name_ref_equip = name_ref_equip;
    }

    public String getDescribe_ref_equip() {
        return describe_ref_equip;
    }

    public void setDescribe_ref_equip(String describe_ref_equip) {
        this.describe_ref_equip = describe_ref_equip;
    }

    public float getValue_ref_equip() {
        return value_ref_equip;
    }

    public void setValue_ref_equip(float value_ref_equip) {
        this.value_ref_equip = value_ref_equip;
    }

    public int getType_param_id() {
        return type_param_id;
    }

    public void setType_param_id(int type_param_id) {
        this.type_param_id = type_param_id;
    }

    public int getSupp_id() {
        return supp_id;
    }

    public void setSupp_id(int supp_id) {
        this.supp_id = supp_id;
    }

    @Override
    public String toString() {
        return "ReferenceParam{" +
                "id_ref_equip=" + id_ref_equip +
                ", name_ref_equip='" + name_ref_equip + '\'' +
                ", describe_ref_equip='" + describe_ref_equip + '\'' +
                ", value_ref_equip=" + value_ref_equip +
                ", type_param_id=" + type_param_id +
                ", supp_id=" + supp_id +
                '}';
    }
}
