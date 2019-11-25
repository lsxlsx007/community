package life.lsx.mycommunity.controller;

import life.lsx.mycommunity.mapper.UserMapper;
import life.lsx.mycommunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
    @GetMapping("/")
    public String index(HttpServletRequest request){
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
        return "index";
    }
}
