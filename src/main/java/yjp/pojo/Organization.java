package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    private Integer id;
    private String name;
    private String organization_id; //机构编号
    private Integer team_num; //队伍人数
    private Integer stu_num; //学生人数
    private Integer tea_num; //指导老师人数
    private Integer is_award; //是否获奖

    public void setName(String name) {
        this.name = name;
    }

    public void setIs_award(Integer is_award) {
        this.is_award = is_award;
    }
}
