package ru.gb.repository;

import java.util.List;
import java.util.Optional;
import ru.gb.domain.Order;

public interface OrderRepository {

  Optional<Order> getById(int id);

  Optional<List<Order>> getAll();

  void save(Order order);
}
