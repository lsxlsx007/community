package life.lsx.mycommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author lsx
 * @Date 2019/11/19 15:15
 * @Version 1.0
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name")String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }
}
