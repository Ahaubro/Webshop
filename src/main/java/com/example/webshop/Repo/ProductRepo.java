package com.example.webshop.Repo;

import com.example.webshop.Model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {

    @Autowired
    JdbcTemplate template;

    // Metode der læser products objekter fra databasen
    public List<Products> readProducts(){
        String sql = "SELECT * FROM products";
        RowMapper<Products> rowMapper = new BeanPropertyRowMapper<>(Products.class);
        return template.query(sql, rowMapper);
    }

    //Metode der tilføjer et nyt product til databasen
    public Products addProduct(Products products) {
        String sql = "INSERT INTO products(name, price) values(?, ?)";
        template.update(sql, products.getName(), products.getPrice());
        return null;
    }

    // Metode der sletter et product fra databasen
    public Boolean deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE productID = ?";
        return template.update(sql, id) > 0;
    }

    // Metode der hiver fat i det ønskede objekt i databasen vha. ID.
    public Products findProductById(int id) {
        String sql = "SELECT * FROM products WHERE productID = ?";
        RowMapper<Products> rowMapper = new BeanPropertyRowMapper<>(Products.class);
        Products products = template.queryForObject(sql, rowMapper, id);
        return products;
    }

    // Metode der redigere et produkt i databasen
    public Products editProduct(int id, Products products){
        String sql = "UPDATE products SET name = ?, price = ? where productID = ?";
        template.update(sql, products.getName(), products.getPrice(), products.getProductID());
        return null;
    }

}
