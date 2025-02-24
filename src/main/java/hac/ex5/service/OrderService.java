package hac.ex5.service;

import hac.ex5.model.Order;
import hac.ex5.model.User;
import hac.ex5.repository.OrderRepository;
import hac.ex5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveOrder(Order order, String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            order.setUser(user);
            orderRepository.save(order);
        }
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findOrdersByUsername(String username) {
        return orderRepository.findByUser_Username(username);
    }

    public void updateOrderStatus(Long orderId, String status) {
        Order order = findOrderById(orderId);
        if (order != null) {
            order.setStatus(status);
            orderRepository.save(order);
        }
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
