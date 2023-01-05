package hi.springagain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
