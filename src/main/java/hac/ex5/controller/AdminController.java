package hac.ex5.controller;

import hac.ex5.model.User;
import hac.ex5.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = adminService.findAllUsers()
                .stream()
                .filter(user -> !user.getRole().equals("ADMIN"))
                .collect(Collectors.toList());
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = adminService.findUserById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping("/users/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        adminService.updateUser(id, user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return "redirect:/admin/users";
    }
}
