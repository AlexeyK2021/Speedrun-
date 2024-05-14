package com.tea.blendingsystem;

import com.tea.blendingsystem.models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private String dbUrl = "127.0.0.1";
    private final String dbPort = "3306"; //3306 - 3305
    private final String dbUser = "root";
    private final String dbPassword = "123054";
    private final String DbName = "tea_ind";

    private final String connectionString;
    private static DbManager instance;


    public static DbManager getInstance() {
        if (instance == null) {
            instance = new DbManager();
        }
        return instance;
    }

    private DbManager() {
        connectionString = "jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + DbName + "?user=" + dbUser + "&password=" + dbPassword;
    }

    public ArrayList<Param> getParams(int equipmentId) {
        try (Connection conn = DriverManager.getConnection(connectionString)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM current_params WHERE equip_id=?");
            stmt.setInt(1, equipmentId);
            ResultSet rs = stmt.executeQuery();


            ArrayList<Param> params = new ArrayList<>();
            while (rs.next()) {
                params.add(new Param(rs));
            }
            return params;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet getTempPressList() {
        try (Connection conn = DriverManager.getConnection(connectionString)) {
            PreparedStatement pr = conn.prepareStatement("SELECT name_cur_param, value_cur_param FROM current_params WHERE name_cur_param = \"Температура\" OR `name_cur_param` = \"Давление\"");
            ResultSet rs = pr.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Equipment> getEquipments() {
        try (Connection conn = DriverManager.getConnection(connectionString)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM equipment");
            ResultSet rs = stmt.executeQuery();

            ArrayList<Equipment> equipment = new ArrayList<>();
            while (rs.next()) {
                equipment.add(new Equipment(rs));
            }
            return equipment;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Log> getLogs(int count) {
        try (Connection conn = DriverManager.getConnection(connectionString)) {
            PreparedStatement stmt = conn.prepareStatement("select * from deviations \n" +
                    "join current_params on cur_param_id = id_cur_param\n" +
                    "join equipment on equip_id = id_equip\n" +
                    "join logi on deviations.id_deviation = logi.deviation_id \n" +
                    "join type_log on type_log.id_type_log = logi.type_log_id;");
            ResultSet rs = stmt.executeQuery();

            ArrayList<Log> logs = new ArrayList<>();
            while (rs.next()) {
                logs.add(new Log(rs));
            }
            return logs;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Deviation> getDeviations() {
        try (Connection conn = DriverManager.getConnection(connectionString)) {
            PreparedStatement stmt = conn.prepareStatement("select * from deviations join current_params on cur_param_id = id_cur_param join equipment on equip_id = id_equip;");
            ResultSet rs = stmt.executeQuery();

            ArrayList<Deviation> devs = new ArrayList<>();
            while (rs.next()) {
                devs.add(new Deviation(rs));
            }
            return devs;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<ReferenceParam> getReferences() {
        try (Connection conn = DriverManager.getConnection(connectionString)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reference_params_tech");
            ResultSet rs = stmt.executeQuery();

            ArrayList<ReferenceParam> rps = new ArrayList<>();
            while (rs.next()) {
                rps.add(new ReferenceParam(rs));
            }
            return rps;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
