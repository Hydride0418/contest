package yjp.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectionQuery {
    private String question_name; //赛题名称
    private String team_name; //团队名称
    private String contest_status; //参赛状态 审核中/审核通过/审核未通过
    private Integer work_status; //作品状态 未提交/提交完成
    private String leader_phone; //队长手机号
    private String leader_school; //队长学校
    private String team_leader; //队长姓名
    private String work_name; //作品名
}
