package com.recycling.gogreen.service.impl;

import com.recycling.gogreen.exception.ResourceNotFound;
import com.recycling.gogreen.model.Product;
import com.recycling.gogreen.model.request.ProductRequest;
import com.recycling.gogreen.model.response.ProductResponse;
import com.recycling.gogreen.repository.ProductRepository;
import com.recycling.gogreen.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = modelMapper.map(productRequest, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductResponse.class);
    }

    @Override
    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream().map((product)
                -> modelMapper.map(product, ProductResponse.class)).collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(long id) {
        Product product = productRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound(String.format("Product with id %d not found", id)));
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public ProductResponse updateProduct(long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound(String.format("Product with id %d not found", id)));

        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        //product.setAddDate(productRequest.getAddDate());
        product.setName(productRequest.getName());
        product.setImage(productRequest.getImage());

        Product updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductResponse.class);
    }

    @Override
    public void deleteProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow(()
                -> new ResourceNotFound(String.format("Product with id %d not found", id)));
        productRepository.delete(product);
    }
}
