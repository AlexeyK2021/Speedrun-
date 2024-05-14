package com.tea.blendingsystem.models;

import com.fasterxml.jackson.datatype.jsr310.deser.key.OffsetDateTimeKeyDeserializer;

import java.sql.ResultSet;
import java.sql.Timestamp;

public class Log {
    private Timestamp datetime;
    private int deviation_id;
    private int type_log_id;
    private Deviation deviation;
    private LogType logType;

    public Log(Timestamp datetime, int deviation_id, int type_log_id) {
        this.datetime = datetime;
        this.deviation_id = deviation_id;
        this.type_log_id = type_log_id;
    }

    public Log(ResultSet rs) {
        try {
            datetime = rs.getTimestamp("datetime_log");
            deviation_id = rs.getInt("deviation_id");
            type_log_id = rs.getInt("type_log_id");
            deviation = new Deviation(rs);
            logType = new LogType(rs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public int getDeviation_id() {
        return deviation_id;
    }

    public void setDeviation_id(int deviation_id) {
        this.deviation_id = deviation_id;
    }

    public int getType_log_id() {
        return type_log_id;
    }

    public void setType_log_id(int type_log_id) {
        this.type_log_id = type_log_id;
    }

    public Deviation getDeviation() {
        return deviation;
    }

    public void setDeviation(Deviation deviation) {
        this.deviation = deviation;
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    @Override
    public String toString() {
        return "Log{" +
                "datetime=" + datetime +
                ", deviation_id=" + deviation_id +
                ", type_log_id=" + type_log_id +
                '}';
    }
}
