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
    private int team_no_rematch;
    private Date submit_date;
}
