package demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import demo.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public JSONObject login(String username, String password) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("msg", "");
        return jsonObject;
    }

    public LoginServiceImpl() {
        System.out.println("init LoginServiceImpl");
    }
}
