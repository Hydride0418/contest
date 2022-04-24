package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;
    private Integer team_id;
    private Integer gender;
    private Date birthday;
    private String school;
    private Integer role; // // 0:学生、普通用户 1：指导老师 2：评审专家 255：管理员
    private Integer is_award; //是否获奖
    private Team team;
    private Question question;
    private Track track;
    private Contest contest;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
