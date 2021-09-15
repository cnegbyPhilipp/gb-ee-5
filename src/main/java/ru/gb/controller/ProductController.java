package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/products")
  public String getAll(Model model) {
    model.addAttribute("products", productService.getAll());
    return "products/products";
  }
}
