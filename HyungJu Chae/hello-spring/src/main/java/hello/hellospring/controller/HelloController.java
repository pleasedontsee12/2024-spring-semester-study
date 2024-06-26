package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","안녕!!!!!");
        return "hello";
    }

    // MVC 방식
    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam(name = "name", required = true) String name, Model model){ //파라미터를 받을 때 @RequestParam
        model.addAttribute("name",name);
        return "hello-template";
    }

    //API 방식 - String
    @GetMapping("hello-string")
    @ResponseBody
    public String hellostring(@RequestParam("name") String name){
        return "hello" + name;
    }

    //API 방식 - 객체
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
