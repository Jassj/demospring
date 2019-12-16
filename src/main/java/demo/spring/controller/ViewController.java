package demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  //控制器注解
public class ViewController {

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String getMenuPage() {
        return "menu";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getMainPage() {
        return "redirect:/pages/main.html";
    }
}
