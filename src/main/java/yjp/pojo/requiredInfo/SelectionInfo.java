package yjp.pojo.requiredInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yjp.pojo.Team;
import yjp.pojo.Work;

//选题信息
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectionInfo {
    private Team team;
    private Work work;
}
