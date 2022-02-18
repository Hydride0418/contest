package yjp.response.AllocationResponse;

import yjp.response.Response;

public class ModifyAllocationResponse extends Response {

    public ModifyAllocationResponse() {
    }

    public ModifyAllocationResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Modify Allocation failed";
        }
    }

    @Override
    public String toString() {
        return "ModifyAllocationResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
