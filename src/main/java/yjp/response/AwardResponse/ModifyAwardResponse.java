package yjp.response.AwardResponse;

import yjp.response.Response;

public class ModifyAwardResponse extends Response {
    public ModifyAwardResponse() {
    }

    public ModifyAwardResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Modify Award failed";
        }
    }

    @Override
    public String toString() {
        return "ModifyAwardResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
