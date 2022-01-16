package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contest {
    private Integer id;
    private String name;
    private Integer time_limit;
    private Integer question_number;
    private Integer archive_status;
    private Integer contest_id;
}
