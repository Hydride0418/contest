package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Integer id;
    private String name;
    private String batch;
    private String works;
    private Integer track_id;
    private String teams;
    private Integer batch_id;
}
