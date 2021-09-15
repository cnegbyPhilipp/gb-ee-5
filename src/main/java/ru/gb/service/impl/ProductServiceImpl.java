package ru.gb.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.gb.dao.ProductDao;
import ru.gb.domain.Product;
import ru.gb.exception.ProductNotFoundException;
import ru.gb.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private static final String PRODUCTS_NOT_FOUND_MESSAGE = "Products not found";
  private static final String PRODUCT_BY_ID_NOT_FOUND_MESSAGE = "Product by id %s not found";

  private final ProductDao productDao;

  @Override
  public Product getById(long id) {
    return productDao
        .findById(id)
        .orElseThrow(() -> throwNotFoundExceptionWithMessage(String.format(PRODUCT_BY_ID_NOT_FOUND_MESSAGE, id)));
  }

  @Override
  public List<Product> getAll() {
    List<Product> products = productDao
        .findAll();
    if (CollectionUtils.isEmpty(products)) {
      throwNotFoundExceptionWithMessage(PRODUCTS_NOT_FOUND_MESSAGE);
    }
    return products;
  }

  private ProductNotFoundException throwNotFoundExceptionWithMessage(String message) {
    throw new ProductNotFoundException(message);
  }
}
