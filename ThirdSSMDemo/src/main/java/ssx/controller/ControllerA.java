package ssx.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ssx.service.ServiceA;

import java.util.List;
import java.util.Map;

@Controller
public class ControllerA {

    @Autowired //Spring的注解：仅当ServiceA的javabean唯一时，自动依赖注入
    ServiceA serviceA;

    @RequestMapping(value = "one/{action}.do")
    public String controllorFun(Model model/*session全局上下文*/, @PathVariable(value = "action")String pram){
        Logger logger = Logger.getLogger(ControllerA.class);//执行日志记录
        logger.info("开始执行后台逻辑");

        List<Map<Object, Object>> maps = serviceA.serviceFun(pram);//调用逻辑层方法
        model.addAttribute("mo1",maps.get(maps.size()-1).toString());//session添加K-V数据
        return "first";//根据返回值寻找对应的页面
    }
}
