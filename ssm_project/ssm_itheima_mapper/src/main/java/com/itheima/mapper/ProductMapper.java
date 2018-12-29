package com.itheima.mapper;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductMapper {

    List<Product> findAll() throws Exception;
    void saveProduct(Product product) throws Exception;
    Product findProductById(String id) throws Exception;
    void updateProduct(Product product) throws Exception;
    void deleteProduct(String id)throws Exception;
}
