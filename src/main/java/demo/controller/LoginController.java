package demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api")
public class LoginController {

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public void login(@RequestBody JSONObject params) {
        System.out.println(params.toString());
    }
}
