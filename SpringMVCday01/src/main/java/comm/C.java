package comm;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class C {
    @RequestMapping(path = "/cc")
    public String fun(User user) {
        System.out.println("this cc method === \n"+user);
        return "anull";
    }
}
