package life.lsx.mycommunity.controller;

import life.lsx.mycommunity.dto.PaginationDTO;
import life.lsx.mycommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IndexController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1")Integer page,
                        @RequestParam(name = "size", defaultValue = "5")Integer size){
        PaginationDTO questionList = questionService.listQuestion(page, size);
        model.addAttribute("questionList", questionList);
        return "index";
    }
}
