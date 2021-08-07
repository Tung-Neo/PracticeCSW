package com.example.abcshop.rest;

import com.example.abcshop.entity.Product;
import com.example.abcshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProduct() {
        return productService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId) {
        Product theProduct = productService.getProduct(productId);
                if (theProduct == null) {
                    throw new ProductNotFoundException("Product id not found - " + productId);
                }
                return theProduct;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product theProduct) {

        theProduct.setId(0);
        productService.saveProduct(theProduct);
        return theProduct;
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product theProduct) {
        productService.saveProduct(theProduct);
        return theProduct;
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        Product tempProduct = productService.getProduct(productId);
        if (tempProduct == null) {
            throw new ProductNotFoundException("Product id not found - " + productId);
        }
        productService.deleteById(productId);
        return "Deleted product id - " + productId;
    }

}
