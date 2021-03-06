package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Product;
import com.itheima.mapper.ProductMapper;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return productMapper.findAll();
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        productMapper.saveProduct(product);
    }

    @Override
    public Product findProductById(String id) throws Exception {
        return productMapper.findProductById(id);
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        productMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(String[] ids) throws Exception {
        for (String id : ids) {
            productMapper.deleteProduct(id);
        }
    }
}
