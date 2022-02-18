package yjp.response.QuestionResponse;

import yjp.response.Response;

public class DeleteQuestionResponse extends Response {
    public DeleteQuestionResponse() {
        super();
    }

    public DeleteQuestionResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        super.generate(success);
    }

    @Override
    public String toString() {
        return "DeleteQuestionResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
