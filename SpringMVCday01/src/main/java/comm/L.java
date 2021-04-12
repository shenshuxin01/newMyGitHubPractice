package comm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class L {
    @RequestMapping(path = "/l")
    public String fun(Model model) {
        model.addAttribute("bbq","bbqv");
        System.out.println();
        return "anull";
    }

}
