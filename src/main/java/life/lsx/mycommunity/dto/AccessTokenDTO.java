package life.lsx.mycommunity.dto;

import lombok.Data;

/**
 * @ClassName AccessTokenDTO
 * @Description TODO
 * @Author lsx
 * @Date 2019/11/19 22:13
 * @Version 1.0
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
