package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private Integer reviewed_num; //评审完成数
    private Integer reviewed; //是否完成评审
    private Integer work_status; //1已提交2未提交0为空值
    private String content;
    private String authors;
    private Integer likes;
    private String contest_name;
}
