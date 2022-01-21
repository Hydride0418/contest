package yjp.response.AllocationResponse;

import yjp.response.Response;

public class AddAllocationResponse extends Response {

    public AddAllocationResponse() {
    }

    public AddAllocationResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add Allocation failed";
        }
    }

    @Override
    public String toString() {
        return "AddAllocationResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
