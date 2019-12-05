package life.lsx.mycommunity.model;

import lombok.Data;

/**
 * @ClassName Question
 * @Description TODO
 * @Author lsx
 * @Date 2019/12/1 14:52
 * @Version 1.0
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreated;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
