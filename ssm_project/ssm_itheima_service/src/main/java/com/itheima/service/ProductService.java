package com.itheima.service;

import com.itheima.domain.Product;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ProductService {
    List<Product> findAll(Integer pageNum, Integer pageSize) throws Exception;
    void saveProduct(Product product) throws Exception;
    Product findProductById(String id) throws Exception;
    void updateProduct(Product product) throws Exception;
    void deleteProduct(String[] ids)throws Exception;
}
