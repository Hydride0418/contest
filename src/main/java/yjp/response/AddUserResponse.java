package yjp.response;

public class AddUserResponse {
    private int code;
    private String message;

    public AddUserResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static AddUserResponse genAddUserResponse(boolean success) {
        if (success) {
            return new AddUserResponse(200, "OK");
        }
        return new AddUserResponse(600, "Add user failed");
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AddUserResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}

