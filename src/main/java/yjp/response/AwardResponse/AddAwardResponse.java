package yjp.response.AwardResponse;

import yjp.response.Response;

public class AddAwardResponse extends Response {
    public AddAwardResponse() {
    }

    public AddAwardResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add Award failed";
        }
    }

    @Override
    public String toString() {
        return "AddAwardResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
