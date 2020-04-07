package demo.spring.controller;

import demo.spring.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @GetMapping(value = "/menu") // 等价于@RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String getMenuPage() {
        return "menu";
    }

    @GetMapping(value = "/main")
    public String getMainPage() {
        return "redirect:/pages/main.html";
    }

    @GetMapping(value = "/student")
    public ModelAndView student() {
        return new ModelAndView("student", "command", new Student());
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap model) {
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        return "result";
    }
}
