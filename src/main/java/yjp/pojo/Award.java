package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Award {
    private Integer id;
    private String name;
    private String type;
    private String grade;
    private Integer cont_id;
    private Integer org_id;
    private Integer user_id;
    private Integer team_id;
}
