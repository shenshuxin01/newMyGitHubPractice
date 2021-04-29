package com.ssx.spring2.ioc;

import com.ssx.entity.POJOUser;
import com.ssx.spring2.IBuy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class Boy implements IBuy {


    @Value("12")
    private String boyName;

    @Resource(name = "pojoUser")
    private POJOUser pojoUser;

    @Override
    public void buy() {
        System.out.println("小男孩买玩具");
        System.out.println(pojoUser.hashCode());
    }
}
