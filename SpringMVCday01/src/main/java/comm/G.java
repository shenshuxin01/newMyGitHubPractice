package comm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/g")
public class G {
    @RequestMapping(path = "/gg/{id}")
    public String fun(@PathVariable(value = "id") String username) {
        System.out.println(username);
        return "anull";
    }
}
