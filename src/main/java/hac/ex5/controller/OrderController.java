package hac.ex5.controller;

import hac.ex5.model.Order;
import hac.ex5.service.OrderService;
import hac.ex5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public String viewUserOrders(@PathVariable Long id, Principal principal, Model model) {
        if (principal == null || !principal.getName().equals(userService.findUserById(id).getUsername())) {
            return "redirect:/login"; // Redirect to login if the user is not authenticated or if the user ID does not match the logged-in user
        }

        List<Order> orders = orderService.findOrdersByUsername(principal.getName());
        model.addAttribute("orders", orders);
        model.addAttribute("userId", id);
        return "user_orders";
    }

    @GetMapping("/new/{id}")
    public String showOrderForm(@PathVariable Long id, Principal principal, Model model) {
        if (principal == null || !principal.getName().equals(userService.findUserById(id).getUsername())) {
            return "redirect:/login"; // Redirect to login if the user is not authenticated or if the user ID does not match the logged-in user
        }

        model.addAttribute("order", new Order());
        return "order_form";
    }

    @PostMapping("/new/{id}")
    public String createOrder(@PathVariable Long id, @ModelAttribute Order order, Principal principal) {
        if (principal == null || !principal.getName().equals(userService.findUserById(id).getUsername())) {
            return "redirect:/login"; // Redirect to login if the user is not authenticated or if the user ID does not match the logged-in user
        }

        order.setUser(userService.findUserById(id));
        orderService.saveOrder(order);
        return "redirect:/orders/user/" + id;
    }
}
