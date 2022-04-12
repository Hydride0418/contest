package yjp.pojo;

import jdk.nashorn.internal.runtime.QuotedStringTokenizer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allocation {
    private Integer id;
    private Integer team_id;
    private Integer expert_id;
    private Integer is_valid; //默认有效（如果退回就是无效的，有效为1，无效为2，默认为0）
    private Integer batch_id;
    private String masks; //分数（每个小项的分数用/进行分割）
    private String advice; //评审意见
    private String sum; //总分
    private Work work;
    private Batch batch;
    private Team team;
    private Question question;
    private Expert expert;
}
