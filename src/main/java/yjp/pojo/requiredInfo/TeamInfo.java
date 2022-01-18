package yjp.pojo.requiredInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yjp.pojo.Question;
import yjp.pojo.Team;

//（团队）参赛信息
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamInfo {
    private Team team;
    private Question question;
}
