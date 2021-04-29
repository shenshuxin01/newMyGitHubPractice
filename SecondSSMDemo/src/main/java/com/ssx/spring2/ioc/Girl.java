package com.ssx.spring2.ioc;

import com.ssx.spring2.IBuy;
import org.springframework.stereotype.Component;

@Component
public class Girl implements IBuy {
    @Override
    public void buy() {
        System.out.println("小女孩买衣服");
    }
}
