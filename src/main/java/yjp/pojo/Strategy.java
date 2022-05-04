package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Strategy {
//    private Integer work_number;
    private Integer work_strategy; // 0: no strategy 1: likes desc
    private Integer picture_number;
    private Integer picture_show_all;// 0: not show all 1: show_all
}
