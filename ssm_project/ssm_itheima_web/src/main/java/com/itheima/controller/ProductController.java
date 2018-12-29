package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "2") Integer pageSize, Model model) throws Exception {
        List<Product> productList = productService.findAll(pageNum,pageSize);
        PageInfo info =new PageInfo(productList);
        model.addAttribute("productList",info);
        return "product-list";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(Product product) throws Exception{
    productService.saveProduct(product);
    return "redirect:findAll";
    }

    @RequestMapping("/findProductById")
    public String findProductById(String id ,Model model) throws Exception {
        Product product = productService.findProductById(id);
        model.addAttribute("product",product);
        return "product-update";
    }
    @RequestMapping("/updateProduct")
    public String updateProduct(Product product) throws Exception {
       productService.updateProduct(product);
        return "redirect:findAll";
    }
    @RequestMapping("/deleteProduct")
    public String deleteProduct(String[] ids ) throws Exception {
        productService.deleteProduct(ids);
        System.out.println(ids);
        return "redirect:findAll";
    }
}
