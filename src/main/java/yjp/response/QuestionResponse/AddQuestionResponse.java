package yjp.response.QuestionResponse;

import yjp.response.Response;

public class AddQuestionResponse extends Response {
    public AddQuestionResponse() {
    }

    public AddQuestionResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success == true) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add question failed";
        }
    }

    @Override
    public String toString() {
        return "AddQuestionResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
