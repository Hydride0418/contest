package yjp.response.QuestionResponse;

import yjp.response.Response;

public class ModifyQuestionResponse extends Response {
    public ModifyQuestionResponse() {
        super();
    }

    public ModifyQuestionResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        super.generate(success);
    }

    @Override
    public String toString() {
        return "ModifyQuestionResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
