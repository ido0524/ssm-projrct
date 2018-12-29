package com.itheima.mapper;

import com.itheima.domain.Member;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;

import java.util.List;
import java.util.Objects;

public interface OrdersMapper {

   Orders findById(String id);
    List<Orders> findAll();
}
