package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    private Integer id;
    private String name;
    private Integer question_id;
    private String participat;
    private String team_leader;
    private String leader_school;
    private String leader_phone;
    private String advisor;
    private Integer team_no_rematch;
    private Integer is_rematch;
    private Integer is_award; //是否获奖
    private Integer org_id; //所属组织id
    private Integer invite_id; //团队邀请码（在新建团队时自动生成）
    private String work_path; //作品文件路径
    private Date submit_date;
    private Work work;
    private Question question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWork_path(String work_path) {
        this.work_path = work_path;
    }
}
