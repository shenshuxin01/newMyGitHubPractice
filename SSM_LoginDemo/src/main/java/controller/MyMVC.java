package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("myMVC")
public class MyMVC {

    @RequestMapping(path = "/funA")
    public String funA() throws Exception {
        System.out.println("mvc-controller-OK");
        mainapp.Main.myBatis_spring();
        return "hello";
    }
}
