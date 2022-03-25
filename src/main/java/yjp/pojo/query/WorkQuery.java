package yjp.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkQuery {
    private String question;
    private String team_name;//团队名称
    private String contest_status;//参赛状态
    private String work_status;//作品状态 TODO
    private String captain_name;//队长姓名
    private String captain_school;//队长学校
    private String captain_phone;//队长手机号
}
