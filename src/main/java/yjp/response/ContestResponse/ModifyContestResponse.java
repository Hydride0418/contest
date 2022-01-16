package yjp.response.ContestResponse;

import lombok.Data;
import yjp.response.Response;

@Data
public class ModifyContestResponse extends Response {
    public ModifyContestResponse() {
    }

    public ModifyContestResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Modify Contest failed";
        }
    }

    @Override
    public String toString() {
        return "ModifyContestResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
