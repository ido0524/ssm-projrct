package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.OrdersService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "4") Integer pageSize, Model model) throws Exception {
        List<Orders> ordersList = ordersService.findAll(pageNum,pageSize);
        PageInfo info= new PageInfo(ordersList);
      model.addAttribute("ordersList",info);
        return "orders-list";
    }
       @RequestMapping("/findById")
    public String findById(String id,Model model){
      Orders orders= ordersService.findById(id);
      model.addAttribute("orders",orders);
        return "orders-show";
    }

}
