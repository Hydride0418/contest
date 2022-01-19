package yjp.response.RuleResponse;

import sun.misc.Request;
import yjp.response.Response;

public class AddRuleResponse extends Response {

    public AddRuleResponse() {
    }

    public AddRuleResponse(int code, String message) {
        super(code, message);
    }

    @Override
    public void generate(boolean success) {
        if (success) {
            this.code = 200;
            this.message = "OK";
        } else {
            this.code = 600;
            this.message = "Add Rule failed";
        }
    }

    @Override
    public String toString() {
        return "AddRuleResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
