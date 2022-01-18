package yjp.response.AdministratorResponse;

import yjp.response.Response;

public class DeleteAdministratorResponse extends Response {

    public DeleteAdministratorResponse() {
    }

    public DeleteAdministratorResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Delete Administrator failed";
        }
    }

    @Override
    public String toString() {
        return "DeleteAdministratorResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
