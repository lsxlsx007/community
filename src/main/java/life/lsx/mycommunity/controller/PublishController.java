package life.lsx.mycommunity.controller;

import life.lsx.mycommunity.mapper.QuestionMapper;
import life.lsx.mycommunity.mapper.UserMapper;
import life.lsx.mycommunity.model.Question;
import life.lsx.mycommunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName PublishController
 * @Description TODO
 * @Author lsx
 * @Date 2019/11/26 9:25
 * @Version 1.0
 */
@Controller
public class PublishController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/doPublish")
    public String doPublish(@RequestParam(value = "title", required = false)String title,
                            @RequestParam(value = "description", required = false)String description,
                            @RequestParam(value = "tag", required = false)String tag,
                            HttpServletRequest request, Model model){
        if(StringUtils.isEmpty(title)){
            model.addAttribute("error", "问题标题不能为空");
            return "publish";
        }
        if(StringUtils.isEmpty(description)){
            model.addAttribute("error", "问题描述不能为空");
            return "publish";
        }
        if(StringUtils.isEmpty(tag)){
            model.addAttribute("error", "问题标签不能为空");
            return "publish";
        }
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setGmtCreated(System.currentTimeMillis());
        question.setGmtModified(System.currentTimeMillis());
        question.setCreator(user.getId());
        questionMapper.insertQuestion(question);
        return "redirect:/";
    }
}
