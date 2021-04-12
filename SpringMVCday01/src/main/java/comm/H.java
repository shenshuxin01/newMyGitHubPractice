package comm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/h")
public class H {
    @RequestMapping(path = "/hh")
    public String fun(@RequestHeader(value = "Accept") String username) {
        System.out.println(username);
        return "anull";
    }
}
