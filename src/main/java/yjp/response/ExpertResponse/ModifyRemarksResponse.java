package yjp.response.ExpertResponse;

import yjp.response.Response;

public class ModifyRemarksResponse extends Response {

    public ModifyRemarksResponse() {
    }

    public ModifyRemarksResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Modify Remarks failed";
        }
    }

    @Override
    public String toString() {
        return "ModifyRemarksResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
