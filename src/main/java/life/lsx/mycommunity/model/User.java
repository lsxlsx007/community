package life.lsx.mycommunity.model;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author lsx
 * @Date 2019/11/25 14:57
 * @Version 1.0
 */
@Data
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
