package site.alexkononsol.siteAKS.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @GetMapping("/")
    public String testPage(@RequestParam(name ="lang",defaultValue = "en",required = false)String lng , HttpServletRequest request){
        logger.info("new connect from ip {} , and language is {}",request.getRemoteAddr(),lng);
        return "index";
    }
}
