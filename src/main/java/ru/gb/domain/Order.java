package ru.gb.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class Order {

  private int id;

  private LocalDate date;

  private int cost;

  private List<Product> products;
}
