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
    private String type; //有指导教师和学生两种类型
    private Integer is_award; //是否获奖
}
