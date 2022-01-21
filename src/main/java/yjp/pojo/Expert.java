package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expert {
    private Integer id;
    private String name;
    private Integer gender;
    private String organization_name;
    private String phone;
    private String email;
    private Date create_date;
    private String remarks;
    private Integer contest_id;
}
