package comm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/f")
public class F {
    @RequestMapping(path = "/ff")
    public String fun(@RequestBody String username) {
        System.out.println(username);
        return "anull";
    }
}
