package main;

import directory.ImplA;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringAopMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathResource =
//                new ClassPathXmlApplicationContext("spring-bean.xml");
                new ClassPathXmlApplicationContext("spring-bean2.xml");

        Object showid = classPathResource.getBean("implA");
        ImplA showid1 = (ImplA) showid;
        showid1.show();
    }
}
