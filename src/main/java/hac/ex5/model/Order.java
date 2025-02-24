package hac.ex5.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Represents an Order entity with a status, user, and a list of pizzas.
 */
@Entity
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<Pizza> pizzas;

    /**
     * Gets the ID of the order.
     *
     * @return the ID of the order
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the order.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the status of the order.
     *
     * @return the status of the order
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the user who placed the order.
     *
     * @return the user who placed the order
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who placed the order.
     *
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the list of pizzas in the order.
     *
     * @return the list of pizzas
     */
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * Sets the list of pizzas in the order.
     *
     * @param pizzas the list of pizzas to set
     */
    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
