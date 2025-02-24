package hac.ex5.service;

import hac.ex5.model.Pizza;
import hac.ex5.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public void savePizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }
}
