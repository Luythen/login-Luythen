package com.github.Luythen.Login.Repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.github.Luythen.Login.Model.ProductModel;
import java.util.List;

public interface  ProductRepository extends CrudRepository<ProductModel, String> {
    List<ProductModel> findAll();
}
