package com.tea.blendingsystem;
import com.tea.blendingsystem.models.Deviation;
import com.tea.blendingsystem.models.Equipment;
import com.tea.blendingsystem.models.Log;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@org.springframework.stereotype.Controller
public class MainController {


    @GetMapping("/logs")
    public String deviationsPage(Model model){
//        var data = new ArrayList<Deviation>();
//        data.add(new Deviation(123123, new Param("Temp", 123f)));
//        data.add(new Deviation(1111, new Param("Temp", 111f)));
        List<Log> logs = DbManager.getInstance().getLogs(20);
//        System.out.println(logs);
        model.addAttribute("logs", logs);
        return "deviationsPage";
    }

    @MessageMapping("/msg")
    @SendTo("/sendTopic")
    public String greeting(String message) throws Exception{
        System.out.println(message);
        return "Hello";
    }
}
