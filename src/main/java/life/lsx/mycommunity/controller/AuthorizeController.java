package life.lsx.mycommunity.controller;

import life.lsx.mycommunity.dto.AccessTokenDTO;
import life.lsx.mycommunity.dto.GithubUser;
import life.lsx.mycommunity.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthorizeController
 * @Description TODO
 * @Author lsx
 * @Date 2019/11/19 22:05
 * @Version 1.0
 */
@Controller
public class AuthorizeController {
    @Autowired
    public GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser != null){
            //登录成功，写cookie和session
            request.getSession().setAttribute("user", githubUser);
            return "redirect:/";
        }else{
            //登录失败，重新登录
            return "redirect:/";
        }
    }
}
