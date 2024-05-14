package com.tea.blendingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlendingsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlendingsystemApplication.class, args);

//        var params = DbManager.getInstance().getParams(5);
//        for (var param : params) {
//            System.out.println(param.toString());
//        }
//
//        var equipment = DbManager.getInstance().getEquipments();
//        for (var equip : equipment) {
//            System.out.println(equip.toString());
//        }
//        var logs = DbManager.getInstance().getLogs(20);
//        for (var log : logs) {
//            System.out.println(log.toString());
//        }
//
//        var devs = DbManager.getInstance().getDeviations();
//        for (var dev : devs) {
//            System.out.println(dev.toString());
//        }
    }

}
