package gruppe1.moranti.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSApp {

    @GetMapping("/")
    public String index(){
        return "../resources/html/overview.html";
    }

}
