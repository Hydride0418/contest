package yjp.response.UserResponse;

import lombok.Data;
import yjp.response.Response;

@Data
public class AddUserResponse extends Response {
    public AddUserResponse() {
    }

    public AddUserResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add User failed";
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
