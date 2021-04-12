package comm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class M {
    @RequestMapping(path = "/m")
    public void fun() {
//        model.addAttribute("bbq","bbqv");
        System.out.println(123);
//        return "anull";
    }

}
