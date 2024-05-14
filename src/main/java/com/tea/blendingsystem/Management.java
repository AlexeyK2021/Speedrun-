package com.tea.blendingsystem;

import java.sql.*;

public class Management {

    public void checkParameters() {          
            ResultSet rs = DbManager.getInstance().getTempPressList();
            while (rs.next()) {
                if (rs.getString("name_cur_param") == "Температура") {
                    checkTemperature(rs.getFloat(1));
                }
                else if (rs.getString("name_cur_param") == "Давление") {
                    setPressure(rs.getFloat(1));
                }
            }
            rs.close();
            pr.close();
    }

    public float checkTemperature(float temperature) {
        if (temperature > 100) {
            temperature -= 0.5f;
        } else if (temperature < 60) {
            temperature += 0.5f;
        }
        System.out.println("Установленная температура: " + temperature);
        return temperature;
    }

    public float setPressure(float pressure) {
        if (pressure > 3.5f) {
            pressure -= 0.5f;
        } else if (pressure < 1.5f) {
            pressure += 0.5f;
        }
        System.out.println("Установленное давление: " + pressure);
        return pressure;
    }

}
