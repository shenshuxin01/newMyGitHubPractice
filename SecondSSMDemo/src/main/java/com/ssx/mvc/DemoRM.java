package com.ssx.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
@Controller
public class DemoRM {


    @RequestMapping("/fun1.do")
    public String fun1(){
        System.out.println("RequestMapping-成功");
        return "demo";
    }

}
