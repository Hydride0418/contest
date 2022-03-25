package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Queue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allocation {
    private Integer id;
    private Integer work_id;
    private Integer expert_id;
    private Integer is_valid; //默认有效
    private Integer batch_id;
    private String masks;
    private String advice;
    private String sum;
    private Work work;
    private Batch batch;
    private Team team;
    private Question question;
    private Expert expert;
}
