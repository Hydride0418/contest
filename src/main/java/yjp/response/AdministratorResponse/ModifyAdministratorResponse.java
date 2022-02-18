package yjp.response.AdministratorResponse;

import yjp.response.Response;

public class ModifyAdministratorResponse extends Response {

    public ModifyAdministratorResponse() {
    }

    public ModifyAdministratorResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Modify Administrator failed";
        }
    }

    @Override
    public String toString() {
        return "ModifyAdministratorResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
