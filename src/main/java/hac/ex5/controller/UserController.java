package hac.ex5.controller;

import hac.ex5.model.User;
import hac.ex5.repository.UserRepository;
import hac.ex5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for managing users.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    /**
     * Shows the registration form for new users.
     *
     * @param model the model to add attributes to
     * @return the name of the registration form view
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * Registers a new user.
     *
     * @param user the user to register
     * @return a redirect to the login page
     */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userService.createUser(user)) {
            return "redirect:/";
        } else {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
    }
}
