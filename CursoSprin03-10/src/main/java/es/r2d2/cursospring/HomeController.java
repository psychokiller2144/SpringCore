package es.r2d2.cursospring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class HomeController {
    
    @GetMapping("/")
    public String home( ){
        log.info("Executing the MVC Spring controller");
        return "index";
    }
    
}
