package hac.ex5.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Represents an Ingredient entity with a name and image URL.
 */
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imageUrl;

    @ManyToMany(mappedBy = "ingredients")
    private List<Pizza> pizzas;

    // Default constructor
    public Ingredient() {
    }

    // Constructor with parameters
    public Ingredient(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    /**
     * Gets the ID of the ingredient.
     *
     * @return the ID of the ingredient
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the ingredient.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the ingredient.
     *
     * @return the name of the ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the ingredient.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the image URL of the ingredient.
     *
     * @return the image URL of the ingredient
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the image URL of the ingredient.
     *
     * @param imageUrl the image URL to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets the list of pizzas that contain this ingredient.
     *
     * @return the list of pizzas
     */
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * Sets the list of pizzas that contain this ingredient.
     *
     * @param pizzas the list of pizzas to set
     */
    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
