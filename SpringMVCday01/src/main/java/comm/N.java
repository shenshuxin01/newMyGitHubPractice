package comm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class N {
    @RequestMapping(path = "/n")
    public ModelAndView fun() {
//        model.addAttribute("bbq","bbqv");
        System.out.println(123);
//        return "anull";
        ModelAndView qwe = new ModelAndView().addObject("qwe", 20);
        qwe.setViewName("anull");
        return qwe;
    }

}
