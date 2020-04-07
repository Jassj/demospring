package demo.spring.controller;

import demo.spring.service.LoginService;
import demo.spring.common.bean.HttpResult;
import demo.spring.test.HelloWorld;
import demo.spring.vo.LoginVo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller  //控制器注解
@RequestMapping("/api") //请求URL映射注解
public class LoginController {

    private LoginService loginService;
    private HelloWorld helloWorld;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public HttpResult login(@RequestBody @Valid LoginVo lv, BindingResult result) {
        if(result.hasErrors()) {
            return new HttpResult("-1", result);
        }
        loginService.login("", "");
        return new HttpResult("0","接收反馈信息成功");
    }

    @GetMapping(value = "/view") // 等价于@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String login() {
        return "menu";
    }
}
