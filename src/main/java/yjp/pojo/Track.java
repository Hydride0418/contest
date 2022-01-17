package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    private Integer id;
    private String name;
    private Integer time_limit;
    private Integer question_number;
    private Integer archive_status;
    private Integer contest_id;
    private Integer pre_contest_id;
}
