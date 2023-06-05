package com.recycling.gogreen.service;

import com.recycling.gogreen.model.request.ProductRequest;
import com.recycling.gogreen.model.response.ProductResponse;

import java.util.List;

public interface ProductService {


    ProductResponse addProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts();

    ProductResponse findById(long id);

    ProductResponse updateProduct(long id, ProductRequest productRequest);

    void deleteProduct(long id);

}
