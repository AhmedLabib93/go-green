package com.recycling.gogreen.controller;

import com.recycling.gogreen.payload.request.ProductRequest;
import com.recycling.gogreen.payload.response.ProductResponse;
import com.recycling.gogreen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/gogreen/v1/products/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity<ProductResponse>(productService.addProduct(productRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@RequestParam(name = "product-id") long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping("/{product-id}")
    public ResponseEntity<ProductResponse> updateProduct(@RequestParam(name = "product-id") long id,
                                                         @RequestBody ProductRequest productRequest) {
        return new ResponseEntity<ProductResponse>(
                productService.updateProduct(id, productRequest),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<String> deleteProduct(@RequestParam(name = "product-id") long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Product deleted successfully!", HttpStatus.ACCEPTED);
    }
}
