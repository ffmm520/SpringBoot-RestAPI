package club.mrhu.startspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * thymeleaf controller
 */
//@RestController
@Controller
public class ThController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
