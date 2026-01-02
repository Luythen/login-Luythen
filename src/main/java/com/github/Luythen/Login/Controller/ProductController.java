package com.github.Luythen.Login.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestParam;

import com.github.Luythen.Login.Model.ProductModel;
import com.github.Luythen.Login.Service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productservice;

    @GetMapping("/")
    public String indexProduct (Model model) {
        model.addAttribute("productList", productservice.getAllProducts());
        return "index";
    }

    @GetMapping("/product/{id}")
    public String detailProductPage (@PathVariable("id") String productID, Model model) {
        model.addAttribute("product", productservice.findProductByID(productID));
        return "product";
    }

    @GetMapping("/product/add")
    public String addNewProduct (@RequestParam("title") String productTitle, @RequestParam("info") String productInfo, @RequestParam("cost") String productCost, @RequestParam("img") String productImgPath) {
        ProductModel newProduct = new ProductModel();
        newProduct.setProductTitle(productTitle);
        newProduct.setProductInfo(productInfo);
        newProduct.setProductCost(Float.valueOf(productCost));
        newProduct.setProductImgPath(productImgPath);
        productservice.createNewProduct(newProduct);
        return "redirect:/";
    }
    

}
