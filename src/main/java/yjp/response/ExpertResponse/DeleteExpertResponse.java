package yjp.response.ExpertResponse;

import yjp.response.AdministratorResponse.DeleteAdministratorResponse;
import yjp.response.Response;

import java.util.Random;

public class DeleteExpertResponse extends Response {

    public DeleteExpertResponse() {
    }

    public DeleteExpertResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Delete Expert failed";
        }
    }

    @Override
    public String toString() {
        return "DeleteExpertResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
