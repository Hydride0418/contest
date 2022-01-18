package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    private Integer id;
    private Integer num;
    private Integer ques_id;
    private Integer track_id;
    private Integer rule_id;
    private String work_id;
    private String expert_id;
    private Integer work_expert;
    private Integer expert_work;
    private Date start_date;
    private Date end_date;
    private Integer is_aveg;
    private Integer is_max;
    private String match_task;
}
