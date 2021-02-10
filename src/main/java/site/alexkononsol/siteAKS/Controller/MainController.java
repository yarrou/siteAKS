package site.alexkononsol.siteAKS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String testPage(){
        return "index";
    }
}
