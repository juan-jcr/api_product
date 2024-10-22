package com.pharmanet.pharmanet.repositories;

import com.pharmanet.pharmanet.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {
}
