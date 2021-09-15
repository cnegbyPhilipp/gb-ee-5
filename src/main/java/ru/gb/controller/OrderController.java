package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.domain.Order;
import ru.gb.service.OrderService;

@Controller
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping("/orders/add")
  public String save(Model model) {
    model.addAttribute("order", new Order());
    return "orders/orders-add";
  }

  @PostMapping("/orders/add")
  public String save(@ModelAttribute Order order, Model model) {
    model.addAttribute("order", order);

    orderService.save(order);
    return "orders/orders-add";
  }

  @GetMapping("orders")
  public String getAll(Model model) {
    model.addAttribute("orders", orderService.geAll());
    return "orders/orders";
  }
}
