package hac.ex5.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a Pizza entity with a list of ingredients and an associated order.
 */
@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "pizza_ingredients",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    /**
     * Gets the ID of the pizza.
     *
     * @return the ID of the pizza
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the pizza.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the list of ingredients in the pizza.
     *
     * @return the list of ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Sets the list of ingredients in the pizza.
     *
     * @param ingredients the list of ingredients to set
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Gets the order associated with the pizza.
     *
     * @return the order associated with the pizza
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the pizza.
     *
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
