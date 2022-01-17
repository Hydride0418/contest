package yjp.response.PreContestResponse;

import yjp.response.Response;

public class ModifyPreContestResponse extends Response {
    public ModifyPreContestResponse() {
        super();
    }

    public ModifyPreContestResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Modify PreContest failed";
        }    }

    @Override
    public String toString() {
        return "ModifyPreContestResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
