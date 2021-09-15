package ru.gb.repository.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import ru.gb.domain.Order;
import ru.gb.domain.Product;
import ru.gb.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

  private static final int ORDERS_COUNT = 5;
  private final List<Order> orders = new ArrayList<>();

  public OrderRepositoryImpl() {
    for (int i = 0; i < ORDERS_COUNT; i++) {
      orders.add(buildOrder(i));
    }
  }

  @Override
  public Optional<Order> getById(int id) {
    return orders.stream()
        .filter(Objects::nonNull)
        .filter(order -> order.getId() == id)
        .findFirst();
  }

  @Override
  public Optional<List<Order>> getAll() {
    return Optional.of(orders);
  }

  @Override
  public void save(Order order) {
    orders.add(order);
  }

  private Order buildOrder(int id) {
    Order order = new Order();
    order.setId(id);
    order.setDate(LocalDate.now());
    order.setProducts(buildProductsList());
    order.setCost(
        order.getProducts()
            .stream()
            .mapToInt(Product::getPrice)
            .sum()
    );
    return order;
  }

  private ArrayList<Product> buildProductsList() {
    return new ArrayList<>();
  }
}
