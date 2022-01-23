package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Work {
    private Integer id;
    private String name;
    private Integer user_id;
    private Integer team_id;
    private Integer ques_id;
    private Integer rule_id;
    private Integer review_num; //完成评审数
}
