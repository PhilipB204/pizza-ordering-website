package hac.ex5.service;

import hac.ex5.model.Ingredient;
import hac.ex5.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public void saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public List<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient findIngredientById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    public Ingredient findIngredientByName(String name) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findByName(name);
        return optionalIngredient.orElse(null);
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    public void updateIngredient(Long id, Ingredient ingredientDetails) {
        Ingredient ingredient = findIngredientById(id);
        if (ingredient != null) {
            ingredient.setName(ingredientDetails.getName());
            ingredient.setImageUrl(ingredientDetails.getImageUrl());
            ingredientRepository.save(ingredient);
        }
    }

    public List<Ingredient> findIngredientsByIds(List<Long> ids) {
        return ingredientRepository.findAllById(ids);
    }
}
