package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkIncident {
    private Integer id;
    private Integer work_id;
    private String incident;
    private String timeStr;
    private String detail;
}
