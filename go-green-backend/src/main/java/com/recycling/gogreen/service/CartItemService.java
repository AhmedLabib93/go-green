package com.recycling.gogreen.service;

import com.recycling.gogreen.payload.request.CartItemRequest;
import com.recycling.gogreen.payload.response.CartItemResponse;

import java.util.List;

public interface CartItemService {

    CartItemResponse addCartItem(CartItemRequest cartItemRequest);

    List<CartItemResponse> getCartItems();

    CartItemResponse getCartItem(long userId, long productId);


    CartItemResponse updateCartItem(CartItemRequest cartItemRequest);

    void deleteCartItem(long userId, long productId);
}
