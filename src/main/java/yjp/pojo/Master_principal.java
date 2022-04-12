package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Master_principal {
    private Integer id;
    private String name;
    private String phone;
    private String organization_id;
    private String organization_name;

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }
}
