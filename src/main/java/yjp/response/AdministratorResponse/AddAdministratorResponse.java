package yjp.response.AdministratorResponse;

import yjp.response.Response;

public class AddAdministratorResponse extends Response {

    public AddAdministratorResponse() {
    }

    public AddAdministratorResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add Administrator failed";
        }
    }

    @Override
    public String toString() {
        return "AddAdministratorResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
