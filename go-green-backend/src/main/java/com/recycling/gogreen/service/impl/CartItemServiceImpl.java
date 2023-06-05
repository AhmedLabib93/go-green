package com.recycling.gogreen.service.impl;

import com.recycling.gogreen.exception.ResourceNotFound;
import com.recycling.gogreen.model.Product;
import com.recycling.gogreen.model.User;
import com.recycling.gogreen.model.cart.CartItem;
import com.recycling.gogreen.model.cart.CartItemPK;
import com.recycling.gogreen.model.request.CartItemRequest;
import com.recycling.gogreen.model.response.CartItemResponse;
import com.recycling.gogreen.repository.CartItemRepository;
import com.recycling.gogreen.repository.ProductRepository;
import com.recycling.gogreen.repository.UserRepository;
import com.recycling.gogreen.service.CartItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    private CartItem findCartItem(long userId, long productId) {
        User user = userRepository.findById(userId).orElseThrow(()
                -> new ResourceNotFound(String.format("User with id %d not found", userId)));
        Product product = productRepository.findById(productId).orElseThrow(()
                -> new ResourceNotFound(String.format("Product with id %d not found", productId)));
        CartItemPK cartItemPK = new CartItemPK();
        cartItemPK.setUser(user);
        cartItemPK.setProduct(product);
        CartItem cartItem = cartItemRepository.findById(cartItemPK).orElseThrow(()
                -> new ResourceNotFound(String.format("CartItem with userId=%d and productId=%d not found",
                userId, productId)));
        return cartItem;
    }

    @Override
    public CartItemResponse addCartItem(CartItemRequest cartItemRequest) {
        CartItem cartItem = modelMapper.map(cartItemRequest, CartItem.class);
        CartItem savedCartItem = cartItemRepository.save(cartItem);
        return modelMapper.map(savedCartItem, CartItemResponse.class);
    }

    @Override
    public List<CartItemResponse> getCartItems() {
        return cartItemRepository.findAll().stream().map((cartItem)
                -> modelMapper.map(cartItem, CartItemResponse.class)).collect(Collectors.toList());
    }

    @Override
    public CartItemResponse getCartItem(long userId, long productId) {
        CartItem cartItem = findCartItem(userId, productId);
        return modelMapper.map(cartItem, CartItemResponse.class);
    }

    @Override
    public CartItemResponse updateCartItem(CartItemRequest cartItemRequest) {
        CartItem cartItem = findCartItem(cartItemRequest.getCartItemPK().getUser().getId(),
                cartItemRequest.getCartItemPK().getProduct().getId());
        cartItem.setQuantity(cartItemRequest.getQuantity());
        CartItem updatedCartItem = cartItemRepository.save(cartItem);
        return modelMapper.map(updatedCartItem, CartItemResponse.class);
    }

    @Override
    public void deleteCartItem(long userId, long productId) {
        CartItem cartItem = findCartItem(userId, productId);
        cartItemRepository.delete(cartItem);
    }
}
