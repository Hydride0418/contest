package yjp.response.ContestResponse;

import lombok.Data;
import yjp.response.Response;

public class AddContestResponse extends Response {
    public AddContestResponse() {
    }

    public AddContestResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add contest failed";
        }
    }

    @Override
    public String toString() {
        return "AddContestResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
