package hac.ex5.controller;

import hac.ex5.model.Ingredient;
import hac.ex5.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public String listIngredients(Model model) {
        List<Ingredient> ingredients = ingredientService.findAllIngredients();
        model.addAttribute("ingredients", ingredients);
        return "ingredient_list"; // Return the view name to list ingredients
    }

    @GetMapping("/{id}")
    public String getIngredient(@PathVariable Long id, Model model) {
        Ingredient ingredient = ingredientService.findIngredientById(id);
        model.addAttribute("ingredient", ingredient);
        return "ingredient_detail"; // Return the view name for ingredient details
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredient_form"; // Return the view name for creating an ingredient
    }

    @PostMapping
    public String createIngredient(@ModelAttribute Ingredient ingredient) {
        ingredientService.saveIngredient(ingredient);
        return "redirect:/ingredients";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Ingredient ingredient = ingredientService.findIngredientById(id);
        model.addAttribute("ingredient", ingredient);
        return "ingredient_form"; // Return the view name for updating an ingredient
    }

    @PostMapping("/{id}")
    public String updateIngredient(@PathVariable Long id, @ModelAttribute Ingredient ingredientDetails) {
        ingredientService.updateIngredient(id, ingredientDetails);
        return "redirect:/ingredients";
    }

    @PostMapping("/{id}/delete")
    public String deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return "redirect:/ingredients";
    }
}
