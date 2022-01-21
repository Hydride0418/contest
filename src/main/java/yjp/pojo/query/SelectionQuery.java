package yjp.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectionQuery {
    private String team_name; //团队名称
    private String work_name; //作品名称
    private String leader_school; //队长学校
    private String team_leader; //队长姓名
}
