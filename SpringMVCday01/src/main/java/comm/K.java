package comm;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

@Controller
@SessionAttributes(value = {"bbc"})
public class K {
    @RequestMapping(path = "/k")
    public String fun(Model model) {
        model.addAttribute("bbc","mkv");
        System.out.println();
        return "anull";
    }

}
