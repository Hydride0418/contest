package yjp.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yjp.pojo.Team;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamAwardQuery {
    private Integer id;
    private String name;
    private String team_leader;
    private String leader_school;
    private String leader_phone;
    private String advisor;
    private Integer is_award; //是否获奖
    private String content;
}
