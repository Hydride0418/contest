package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allocation {
    private Integer id;
    private Integer work_id;
    private Integer expert_id;
    private Integer is_valid; //默认有效
    private String masks;
    private String advice;
}
