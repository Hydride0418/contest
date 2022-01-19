package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rule {
    private Integer id;
    private String name;
    private Integer title_colu;
    private Integer is_use_wei;
    private Integer is_valid;
    private String head_info;
    private Integer num;
}
