package com.tea.blendingsystem;
import com.tea.blendingsystem.models.Deviation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@org.springframework.stereotype.Controller
public class MainController {


    @GetMapping("/hello")
    public String hello(Model model){
//        var data = new ArrayList<Deviation>();
//        data.add(new Deviation(123123, new Param("Temp", 123f)));
//        data.add(new Deviation(1111, new Param("Temp", 111f)));
        List<Deviation> deviations = DbManager.getInstance().getDeviations();
        System.out.println(deviations);
        model.addAttribute("devs", deviations);
        return "hello";
    }
}
