package yjp.response.ExpertResponse;

import yjp.pojo.Expert;
import yjp.response.Response;

import java.util.Random;

public class AddExpertResponse extends Response {

    public AddExpertResponse() {
    }

    public AddExpertResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add Expert failed";
        }
    }

    @Override
    public String toString() {
        return "AddExpertResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
