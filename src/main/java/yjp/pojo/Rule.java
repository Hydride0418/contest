package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rule {
    private Integer id;
    private String name; //名称
    private Integer title_colu; //表头数量
    private String is_use_wei; //是否加权求和
    private String is_valid; //是否有效
    private String head_info; //表头信息
}
