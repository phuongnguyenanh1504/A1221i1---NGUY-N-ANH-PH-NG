package com.casestudy.service;

import com.casestudy.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    public void insertProduct(Product product);
    public Product selectProduct(int id);
    public List<Product> selectAllProduct();
    public boolean deleteProduct(int id);
    public boolean updateProduct(Product product) throws SQLException;
    public List<Product> findProduct(String s);
}
