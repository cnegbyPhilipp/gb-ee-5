package ru.gb.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.dao.ProductDao;
import ru.gb.domain.Product;

@Component
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

  private final EntityManager entityManager;

  @Override
  public Optional<Product> findById(Long id) {
    entityManager.getTransaction().begin();
    Product product = entityManager.find(Product.class, id);
    entityManager.getTransaction().commit();
    return Optional.ofNullable(product);
  }

  @Override
  public List<Product> findAll() {
    return entityManager.createQuery("select p from product p", Product.class).getResultList();
  }

  @Override
  public void deleteById(Long id) {
    TypedQuery<Product> query = entityManager.createQuery("delete from product p where id=?1", Product.class);
    query.setParameter(1, id);
    query.executeUpdate();
  }

  @Override
  public Product saveOrUpdate(Product product) {
    Optional<Product> p = findById(product.getId());

    if (p.isPresent()) {
      entityManager.getTransaction().begin();
      Product merged = entityManager.merge(product);
      entityManager.getTransaction().commit();
      return merged;
    } else {
      entityManager.getTransaction().begin();
      entityManager.persist(product);
      entityManager.getTransaction().commit();
      return product;
    }
  }

}
