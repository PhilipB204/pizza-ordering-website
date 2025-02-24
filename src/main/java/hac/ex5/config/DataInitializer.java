package hac.ex5.config;

import hac.ex5.service.AdminService;
import hac.ex5.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private AdminService adminService;

    @Override
    public void run(String... args) throws Exception {
        /*   initializeIngredients();*/
        initializeAdminUser();
    }

   /* private void initializeIngredients() {
        List<String> ingredientNames = List.of(
                "Black Olives", "Cheese", "Green Olives",
                "Green Pepper", "Mushrooms", "Onions", "Parmesan"
        );

        List<String> ingredientImages = List.of(
                "/images/black_olives.png", "/images/cheese.png", "/images/green_olives.png",
                "/images/green_pepper.png", "/images/mushrooms.png", "/images/onions.png", "/images/parmesan.png"
        );

        for (int i = 0; i < ingredientNames.size(); i++) {
            if (ingredientService.findIngredientByName(ingredientNames.get(i)) == null) {
                ingredientService.saveIngredient(new Ingredient(ingredientNames.get(i), ingredientImages.get(i)));
            }
        }
    }*/

    private void initializeAdminUser() {
        System.out.println("Creating admin user...");
        adminService.createAdminUser();
        System.out.println("Admin user creation process completed.");
    }
}
