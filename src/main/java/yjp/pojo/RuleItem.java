package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleItem { //rule中的详细条目
    private Integer id;
    private String scorePoint; //评分点
    private String remarks; //备注
    private Integer minPoint; //最小分值
    private Integer fulPoint; //满分
    private Integer rule_id; //所属规则编号
    private Rule rule;
    private Batch batch;
    private Allocation allocation;
}
