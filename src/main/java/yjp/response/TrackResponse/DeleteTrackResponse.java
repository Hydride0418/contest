package yjp.response.TrackResponse;

import yjp.response.Response;

public class DeleteTrackResponse extends Response {
    public DeleteTrackResponse() {
        super();
    }

    public DeleteTrackResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Delete track failed";
        }    }

    @Override
    public String toString() {
        return "DeleteTrackResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
