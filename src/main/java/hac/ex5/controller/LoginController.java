package hac.ex5.controller;

import hac.ex5.model.User;
import hac.ex5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.authenticateUser(username, password)) {
            User user = userService.findUserByUsername(username);
            return "redirect:/orders/user/" + user.getId(); // Redirect to the user's orders page
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "home";
        }
    }
}
