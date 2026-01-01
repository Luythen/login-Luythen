package com.github.Luythen.Login.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Luythen.Login.Model.ProductModel;
import com.github.Luythen.Login.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductModel findProductByID (String productID) {
        return productRepository.findById(productID).get();
    }

    public List<ProductModel> getAllProducts () {
        return productRepository.findAll();
    }

    public void createNewProduct (ProductModel pModel) {
        productRepository.save(pModel);
    }

}
