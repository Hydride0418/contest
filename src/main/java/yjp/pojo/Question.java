package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Integer id;
    private String name;
    private Integer track_id;
    private Integer batch_id;
    private Integer contest_id;
    private String content;
    private List<Team> team;
}
