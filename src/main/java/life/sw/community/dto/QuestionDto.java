package life.sw.community.dto;

import life.sw.community.model.User;
import lombok.Data;

@Data
public class QuestionDto {
    private Integer id;
    private String description;
    private String title;
    private String tag;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private Integer creator;
    private Long gmtCreate;
    private Long gmtModified;
    private User user;
}
