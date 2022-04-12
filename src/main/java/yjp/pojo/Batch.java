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
    private String name;
    private Integer track_id;
    private Integer rule_id;
    private Integer work_expert;
    private Integer expert_work;
    private Date start_date;
    private Date end_date;
    private String is_aveg;
    private String is_max;
    private Track track;
    private Contest contest;
    private Rule rule;
}
