package yjp.response.ExpertResponse;

import yjp.response.Response;

public class ModifyRemarkResponse extends Response {

    public ModifyRemarkResponse() {
    }

    public ModifyRemarkResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Modify Remark failed";
        }
    }

    @Override
    public String toString() {
        return "ModifyRemarkResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
