package yjp.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamQuery {
    private String team_name; //团队名称
    private String contest_status; //参赛状态
    private String leader_phone; //队长手机号
    private String leader_school; //队长学校
    private String team_leader; //队长姓名
}
