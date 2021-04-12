package comm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A {

    @RequestMapping(path = "/aa")
    public String fun() {
        System.out.println("123");
        return "anull";
    }
}
