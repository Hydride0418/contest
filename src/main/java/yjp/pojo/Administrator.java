package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender;
    private String affiliation;
    private String privatePhone;
    private String email;
    private String officePhone;
    private String qqNumber;
    private String address;
    private String postcode;
}
