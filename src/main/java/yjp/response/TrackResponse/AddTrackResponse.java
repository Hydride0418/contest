package yjp.response.TrackResponse;

import yjp.response.Response;

public class AddTrackResponse extends Response {
    public AddTrackResponse() {
        super();
    }

    public AddTrackResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add track failed";
        }
    }

    @Override
    public String toString() {
        return "AddTrackResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
