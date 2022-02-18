package yjp.response.ExpertResponse;

import yjp.response.AdministratorResponse.ModifyAdministratorResponse;
import yjp.response.Response;

public class ModifyExpertResponse extends Response {

    public ModifyExpertResponse() {
    }

    public ModifyExpertResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Modify Expert failed";
        }
    }

    @Override
    public String toString() {
        return "ModifyExpertResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
