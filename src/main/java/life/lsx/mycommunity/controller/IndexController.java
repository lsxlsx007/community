package life.lsx.mycommunity.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author lsx
 * @Date 2019/11/19 15:15
 * @Version 1.0
 */
@Controller
public class IndexController {
    @Value("${github.authorize.address}")
    private String AUTHORIZE_ADDRESS;
    @Value("${github.client.id}")
    private String CLIENT_ID;
    @Value("${github.client.secret}")
    private String CLIENT_SECRET;
    @Value("${github.redirect.uri}")
    private String CALLBACK_URL;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("address", AUTHORIZE_ADDRESS);
        model.addAttribute("clientId", CLIENT_ID);
        model.addAttribute("clientSecret", CLIENT_SECRET);
        model.addAttribute("callbackUrl", CALLBACK_URL);
        return "index";
    }
}
