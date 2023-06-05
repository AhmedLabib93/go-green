package com.recycling.gogreen.service;

import com.recycling.gogreen.model.request.CartItemRequest;
import com.recycling.gogreen.model.response.CartItemResponse;
import com.recycling.gogreen.repository.CartItemRepository;
import com.recycling.gogreen.repository.ProductRepository;
import com.recycling.gogreen.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CartItemService {

    CartItemResponse addCartItem(CartItemRequest cartItemRequest);

    List<CartItemResponse> getCartItems();

    CartItemResponse getCartItem(long userId, long productId);


    CartItemResponse updateCartItem(CartItemRequest cartItemRequest);

    void deleteCartItem(long userId, long productId);
}
