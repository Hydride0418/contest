package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Award {
    private Integer id;
    private String name; //奖项名称
    private String type; //类型
    private String grade; //等级
    private Integer cont_id;
    private Integer org_id;
    private Integer team_id;
    private Integer user_id;
    private User user;
    private Contest contest; //赛事(名称)
    private Question question; //赛题（名称）
    private Track track; //分赛
    private Team team; //团队（名称）

    public Integer getOrg_id() {
        return org_id;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public Integer getUser_id() {
        return user_id;
    }
}
