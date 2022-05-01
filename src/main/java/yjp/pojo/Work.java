package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Work {
    private Integer id;
    private String name;
    private Integer user_id; //队长ID
    private Integer team_id;
    private Integer ques_id;
    private Integer rule_id;
    private Double aveg_sum; //平均分
    private Integer review_num; //需要评审数
    private Integer reviewed_num; //评审完成数
    private Integer reviewed; //是否完成评审
    private Integer likes;
    private String authors;
    private String contest_name;
    private String content;
    private Batch batch;
    private Team team;
    private Question question;
}
