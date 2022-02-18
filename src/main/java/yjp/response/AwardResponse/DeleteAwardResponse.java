package yjp.response.AwardResponse;

import yjp.response.Response;

public class DeleteAwardResponse extends Response {
    public DeleteAwardResponse() {
    }

    public DeleteAwardResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Delete Award failed";
        }
    }

    @Override
    public String toString() {
        return "DeleteAwardResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
