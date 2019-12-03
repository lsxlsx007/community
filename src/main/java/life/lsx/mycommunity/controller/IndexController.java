package life.lsx.mycommunity.controller;

import life.lsx.mycommunity.dto.PaginationDTO;
import life.lsx.mycommunity.dto.QuestionDTO;
import life.lsx.mycommunity.mapper.QuestionMapper;
import life.lsx.mycommunity.mapper.UserMapper;
import life.lsx.mycommunity.model.User;
import life.lsx.mycommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1")Integer page,
                        @RequestParam(name = "size", defaultValue = "5")Integer size){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length>0){
            for(Cookie k : cookies){
                if(k.getName().equals("token")){
                    String token = k.getValue();
                    //Alt + 回车生成方法
                    User user =  userMapper.findByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        PaginationDTO questionList = questionService.listQuestion(page, size);
        model.addAttribute("questionList", questionList);
        return "index";
    }
}
