package yjp.response.PreContestResponse;

import yjp.response.Response;

public class DeletePreContestResponse extends Response {
    public DeletePreContestResponse() {
        super();
    }

    public DeletePreContestResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Delete PreContest failed";
        }
    }

    @Override
    public String toString() {
        return "DeletePreContestResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
