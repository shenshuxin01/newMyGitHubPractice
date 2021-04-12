package comm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class B {
    @RequestMapping(path = "/bb")
    public String fun(String user,String age) {
        System.out.println("this bb method === "+user+age);
        return "anull";
    }
}
