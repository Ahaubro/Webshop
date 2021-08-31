package com.example.webshop.Controller;

import com.example.webshop.Model.Products;
import com.example.webshop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String readProducts(Model model) {
        List<Products> products = productService.readProducts();
        model.addAttribute("products", products);
        return"/products";
    }

    @GetMapping("/addProductsGet")
    public String addProductsGet() {
        return "/addProducts";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Products products) {
        productService.addProduct(products);
        return "redirect:/";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "/editProduct";
    }

    // Update customer post metode
    @PostMapping("/editProduct")
    public String editProduct(@ModelAttribute Products products) {
        productService.editProduct(products.getProductID(), products);
        return "redirect:/";
    }


}
