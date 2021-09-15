package ru.gb.service;

import java.util.List;
import ru.gb.domain.Order;

public interface OrderService {

  Order getById(int id);

  List<Order> geAll();

  void save(Order order);
}
