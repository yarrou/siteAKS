package site.alexkononsol.siteAKS.Controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import site.alexkononsol.siteAKS.SiteAksApplication;
import java.io.IOException;

@Controller
public class PdfController {
    @GetMapping(
            value = "/get-cv",
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public @ResponseBody
    byte[] getPdfWithMediaType(@RequestParam(defaultValue = "ru")String lng ) throws IOException {
        String pathToCV = null;
        if(lng.equals("eng")){
            pathToCV = "static/pdf/Aleksandr Kononovich_cv_eng.pdf";
        }else if(lng.equals("by")){
            pathToCV = "static/pdf/Aleksandr Kononovich_cv_by.pdf";
        }else pathToCV = "static/pdf/Aleksandr Kononovich_cv_ru.pdf";
        byte[] content = SiteAksApplication.class.getClassLoader().getResourceAsStream(pathToCV).readAllBytes();
        return content;
    }

}
