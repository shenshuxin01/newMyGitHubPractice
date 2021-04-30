package com.ssx.mvc;

import com.ssx.dao.AnnoIDao;
import com.ssx.entity.POJOUser;
import com.ssx.util.SpringUtil;
import com.ssx.util.UseBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
@Controller
public class DemoRM {


    @RequestMapping("/fun1/{action}.do")
    public String fun1(/*@RequestBody POJOUser pojoUser,*/ @PathVariable String action){
//        System.out.println("RequestMapping-成功");
//        UseBean.use(action, AnnoIDao.class).annoQuery("zx").forEach(pojoUser1 -> System.out.println(pojoUser1));
        SpringUtil.getBean(action,AnnoIDao.class).annoQuery("zx").forEach(pojoUser1 -> System.out.println(pojoUser1));
        return "demo";
    }

}
