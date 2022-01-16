package yjp.response.ContestResponse;

import com.alibaba.fastjson.JSONObject;
import yjp.response.Response;

public class RespTest {
    public static void main(String[] args) {
        AddContestResponse addContestResponse = new AddContestResponse();
        addContestResponse.generate(true);
        System.out.println(addContestResponse.toString());
        System.out.println(JSONObject.toJSONString((Response)addContestResponse));
    }
}
