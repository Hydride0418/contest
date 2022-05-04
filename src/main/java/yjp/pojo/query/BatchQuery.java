package yjp.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchQuery {
    private String batch_name; //批次名称
    private String rule_name; //指标名称
    private String contest_name; //赛事名称
}
