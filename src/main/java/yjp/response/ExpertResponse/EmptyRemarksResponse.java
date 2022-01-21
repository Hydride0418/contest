package yjp.response.ExpertResponse;

import yjp.response.Response;

public class EmptyRemarksResponse extends Response {

    public EmptyRemarksResponse() {
    }

    public EmptyRemarksResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Empty remarks failed";
        }
    }

    @Override
    public String toString() {
        return "EmptyRemarksResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
