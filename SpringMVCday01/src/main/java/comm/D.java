package comm;

import com.sun.net.httpserver.HttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class D {
    @RequestMapping(path = "/dd")
    public String fun(HttpServletRequest httpServletRequest ) {
        System.out.println("123");
        System.out.println(httpServletRequest.toString());
        return "anull";

    }
}
