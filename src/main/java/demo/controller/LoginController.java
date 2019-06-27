package demo.controller;

import com.alibaba.fastjson.JSONObject;
import demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //控制器注解
@RequestMapping("/api") //请求映射注解
public class LoginController {

    @Autowired//自动连接注解,省去声明setter方法
    private LoginService loginService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody JSONObject params) {
        JSONObject jsonObject = loginService.login(params.get("username").toString(), params.get("password").toString());
        return jsonObject;
    }
}
