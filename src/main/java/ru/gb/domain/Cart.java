package ru.gb.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.service.ProductService;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
@Slf4j
@RequiredArgsConstructor
public class Cart {

  private final ProductService productService;

  private final List<Product> products = new ArrayList<>();

  public void putById(long id) {
    products.add(productService.getById(id));
    log.info("Products in cart: {}", products);
  }

  public void putAll() {
    products.addAll(productService.getAll());
    log.info("Products in cart: {}", products);
  }
}
