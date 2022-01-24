package yjp.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yjp.pojo.Allocation;
import yjp.pojo.Batch;
import yjp.pojo.Question;
import yjp.pojo.Team;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewQuery {
    private String batch_name;
    private String team_name;
    private String work_name;
    private String ques_name;
    private String team_leader;
    private String leader_school;
    private String leader_phone;
    private Integer reviewed;
    private Team team;
    private Question question;
    private Batch batch;
    private Allocation allocation;
}
