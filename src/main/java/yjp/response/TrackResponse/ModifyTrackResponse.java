package yjp.response.TrackResponse;

import yjp.response.Response;

public class ModifyTrackResponse extends Response {
    public ModifyTrackResponse() {
        super();
    }

    public ModifyTrackResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Modify track failed";
        }
    }

    @Override
    public String toString() {
        return "ModifyTrackResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
