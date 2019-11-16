package demo.api.controller;

import demo.api.service.LoginService;
import demo.api.vo.LoginVo;
import demo.spring.bean.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller  //控制器注解
@RequestMapping("/api") //请求URL映射注解
public class LoginController {

    @Autowired //自动连接注解,省去声明setter方法
    private LoginService loginService;

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult login(@RequestBody @Valid LoginVo lv, BindingResult result) {
        if(result.hasErrors()) {
            return new HttpResult("-1", result);
        }
        return new HttpResult("0","接收反馈信息成功");
    }
}
