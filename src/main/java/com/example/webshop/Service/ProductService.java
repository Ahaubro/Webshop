package com.example.webshop.Service;

import com.example.webshop.Model.Products;
import com.example.webshop.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Products> readProducts() {
        return productRepo.readProducts();
    }

    public Products addProduct(Products products) {
        return productRepo.addProduct(products);
    }

    public Boolean deleteProduct(int id) {
        return productRepo.deleteProduct(id);
    }

    public Products findProductById(int id) {
        return productRepo.findProductById(id);
    }

    public Products editProduct(int id, Products products) {
        return productRepo.editProduct(id, products);
    }



}
