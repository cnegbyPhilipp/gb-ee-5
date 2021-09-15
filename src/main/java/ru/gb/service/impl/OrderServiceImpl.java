package ru.gb.service.impl;

import java.util.List;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.domain.Order;
import ru.gb.exception.OrderNotFoundException;
import ru.gb.repository.OrderRepository;
import ru.gb.service.OrderService;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private static final String ORDER_BY_ID_NOT_FOUND_MESSAGE = "Order by id %s not found";
  private static final String ORDERS_NOT_FOUND_MESSAGE = "Orders not found";

  private final OrderRepository orderRepository;

  @Override
  public Order getById(int id) {
    return orderRepository.getById(id)
        .orElseThrow(throwOrderNotFoundExceptionWithMessage(String.format(ORDER_BY_ID_NOT_FOUND_MESSAGE, id)));
  }

  @Override
  public List<Order> geAll() {
    return orderRepository.getAll()
        .orElseThrow(throwOrderNotFoundExceptionWithMessage(ORDERS_NOT_FOUND_MESSAGE));
  }

  @Override
  public void save(Order order) {
    log.info("Add new order {}", order);
    orderRepository.save(order);
  }

  private Supplier<OrderNotFoundException> throwOrderNotFoundExceptionWithMessage(String ordersNotFoundMessage) {
    return () -> new OrderNotFoundException(ordersNotFoundMessage);
  }
}
