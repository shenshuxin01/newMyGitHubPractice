package com.ssx.spring2.ioc;

import com.ssx.spring2.IBuy;
import org.springframework.stereotype.Component;

@Component
public class Boy implements IBuy {
    @Override
    public void buy() {
        System.out.println("小男孩买玩具");
    }
}
