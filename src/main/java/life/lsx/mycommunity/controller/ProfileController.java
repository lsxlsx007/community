package life.lsx.mycommunity.controller;

import life.lsx.mycommunity.dto.PaginationDTO;
import life.lsx.mycommunity.mapper.QuestionMapper;
import life.lsx.mycommunity.mapper.UserMapper;
import life.lsx.mycommunity.model.User;
import life.lsx.mycommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ProfileController
 * @Description TODO
 * @Author lsx
 * @Date 2019/12/3 10:38
 * @Version 1.0
 */
@Controller
public class ProfileController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name="action")String action,
                          Model model,
                          @RequestParam(name="page", defaultValue = "1")Integer page,
                          @RequestParam(name="size", defaultValue = "5")Integer size){

        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/";
        }
        if("questions".equals(action)){
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        }else if("replies".equals(action)){
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }
        PaginationDTO questionList = questionService.listQuestion(page, size);
        model.addAttribute("questionList", questionList);
        return "profile";
    }
}
