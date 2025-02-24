package hac.ex5.controller;

import hac.ex5.model.Ingredient;
import hac.ex5.model.Order;
import hac.ex5.model.Pizza;
import hac.ex5.service.IngredientService;
import hac.ex5.service.OrderService;
import hac.ex5.service.PizzaService;
import hac.ex5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/customize")
    public String customizePizza(Model model) {
        List<Ingredient> ingredients = ingredientService.findAllIngredients();
        model.addAttribute("ingredients", ingredients);
        return "customize_pizza";
    }

    @PostMapping("/customize")
    public String orderPizza(@RequestParam List<Long> ingredientIds, Principal principal, Model model) {
        // Assume User entity has a method to fetch user by username
        // Create a new order and pizza
        Order order = new Order();
        order.setUser(userService.findUserByUsername(principal.getName()));
        order.setStatus("Pending");

        Pizza pizza = new Pizza();
        pizza.setIngredients(ingredientService.findIngredientsByIds(ingredientIds));
        pizza.setOrder(order);

        order.setPizzas(List.of(pizza));

        orderService.saveOrder(order);
        pizzaService.savePizza(pizza);

        model.addAttribute("order", order);
        return "order_details";
    }
}
