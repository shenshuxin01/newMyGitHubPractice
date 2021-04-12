package comm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value = "/h")
public class I {
    @RequestMapping(path = "/i")
    public String fun(@CookieValue(value = "JSESSIONID") String username) {
        System.out.println(username);
        return "anull";
    }
}
