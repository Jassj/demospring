package demo.spring.service.impl;

import demo.spring.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public JSONObject login(String username, String password) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("msg", "登录成功");
        return jsonObject;
    }

    public LoginServiceImpl() {
        System.out.println("init LoginServiceImpl");
    }
}
