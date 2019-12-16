package demo.api.controller;

import demo.api.service.LoginService;
import demo.spring.bean.HttpResult;
import demo.spring.test.HelloWorld;
import demo.vo.LoginVo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller  //控制器注解
@RequestMapping("/api") //请求URL映射注解
public class LoginController {

    /**
     * Field injection is not recommended --- @Autowired自动装配注解声明在字段上,省去声明setter方法
     * Always use constructor based dependency injection in your beans. Always use assertions for mandatory dependencies
     * 不推荐使用字段注入,推荐使用基于构造函数的依赖注入--仅有一个构造函数可以使用@Autowired,Todo 推荐对强制性依赖使用断言???
     */
    private final LoginService loginService; // Todo 声明为final??
    private HelloWorld helloWorld;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
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
