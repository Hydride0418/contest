package yjp.response.PreContestResponse;

import yjp.response.Response;

public class AddPreContestResponse extends Response {
    public AddPreContestResponse() {
        super();
    }

    public AddPreContestResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add PreContest failed";
        }
    }

    @Override
    public String toString() {
        return "AddPreContestResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
