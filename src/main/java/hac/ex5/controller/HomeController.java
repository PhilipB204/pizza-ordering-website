package hac.ex5.controller;

import hac.ex5.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Add any necessary model attributes
        model.addAttribute("user", new User()); // Add user attribute for login
        return "home";
    }
}
