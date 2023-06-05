package com.recycling.gogreen.service;

import com.recycling.gogreen.payload.request.ProductRequest;
import com.recycling.gogreen.payload.response.ProductResponse;

import java.util.List;

public interface ProductService {


    ProductResponse addProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts();

    ProductResponse getProductById(long id);

    ProductResponse updateProduct(long id, ProductRequest productRequest);

    void deleteProduct(long id);

}
