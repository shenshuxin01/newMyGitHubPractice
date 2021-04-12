package comm;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class J {
    @RequestMapping(path = "/j")
    public String fun(@ModelAttribute(value = "abcc") User user) {
        System.out.println(user);
        return "anull";
    }

    @ModelAttribute
    public void testModeAttribute(Map<String,User> map){
        System.out.println("testModeAttribute..");
        User user = new User();
        user.setName("ssxx");
        map.put("abcc", user);

    }
}
