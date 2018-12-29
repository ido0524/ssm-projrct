package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.mapper.OrdersMapper;
import com.itheima.mapper.ProductMapper;
import com.itheima.service.OrdersService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAll(Integer pageNum, Integer pageSize) throws Exception {
       PageHelper.startPage(pageNum,pageSize);
        return ordersMapper.findAll();
    }

    @Override
    public Orders findById(String id) {
        return ordersMapper.findById(id);
    }


}
