package yjp.response.BatchResponse;

import yjp.response.Response;

public class AddBatchResponse extends Response {
    public AddBatchResponse() {
    }

    public AddBatchResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add Batch failed";
        }
    }

    @Override
    public String toString() {
        return "AddBatchResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
