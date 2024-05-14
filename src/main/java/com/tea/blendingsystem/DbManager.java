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
    private final String dbPassword = "1234";
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
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM logi ORDER BY datetime_log DESC LIMIT ?");
            stmt.setInt(1, count);
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
            PreparedStatement stmt = conn.prepareStatement("select * from deviations join current_params on cur_param_id = id_cur_param;");
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
