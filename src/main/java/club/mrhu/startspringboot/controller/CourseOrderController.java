package club.mrhu.startspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("courseorder")
public class CourseOrderController {

    @RequestMapping("list")
    public String list() {
        return "courseorder/list";
    }
}
