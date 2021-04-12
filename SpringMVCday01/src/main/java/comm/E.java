package comm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/e")
public class E {
    @RequestMapping(path = "/ee")
    public String fun(@RequestParam(value = "uname") String username) {
        System.out.println("123"+username);
        return "anull";
    }
}
