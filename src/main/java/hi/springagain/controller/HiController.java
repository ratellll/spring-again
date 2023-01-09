package hi.springagain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiController {

    @GetMapping("hi")
    public String hi(Model model) {
        model.addAttribute("data", "hi!!!");
        model.addAttribute("name", "현빈이에요");
        model.addAttribute("age", "말안해줄거에요");
        return "hi";
    }

    @GetMapping("hi-mvc")
    public String hiMvc(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("money") String money, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("money", money);

        return "hi-template";
    }

    @GetMapping("hi-spring")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hi" + name;
    }

    @GetMapping("hi-api")
    @ResponseBody //내가 직접 바디에 넣겠따
    public Hi hiApi(@RequestParam("name") String name) {
        Hi hi = new Hi();
        hi.setName(name);
        return hi;
    }


    static class Hi {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
