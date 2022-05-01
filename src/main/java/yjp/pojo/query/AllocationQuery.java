package yjp.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import yjp.pojo.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllocationQuery {
    private String batch_name;
    private String team_name;
    private String work_name;
    private String ques_name;
    private String expert_name;
    private String expert_organization_name;
    private Integer is_valid;
}
