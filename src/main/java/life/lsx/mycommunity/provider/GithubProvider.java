package life.lsx.mycommunity.provider;

import com.alibaba.fastjson.JSON;
import life.lsx.mycommunity.dto.AccessTokenDTO;
import life.lsx.mycommunity.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName GithubProvider
 * @Description TODO
 * @Author lsx
 * @Date 2019/11/19 22:12
 * @Version 1.0
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        String json = JSON.toJSONString(accessTokenDTO);
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String[] split = string.split("&");
            String accessToken = split[0].split("=")[1];
            System.out.println("获取accessToken:" + string);
            return accessToken;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        try{
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token=" + accessToken)
                    .build();
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
