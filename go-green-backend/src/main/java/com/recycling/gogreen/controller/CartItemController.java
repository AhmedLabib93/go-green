package com.recycling.gogreen.controller;

import com.recycling.gogreen.payload.request.CartItemRequest;
import com.recycling.gogreen.payload.response.CartItemResponse;
import com.recycling.gogreen.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/gogreen/v1/cartitems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<CartItemResponse> addCartItem(@RequestBody CartItemRequest cartItemRequest) {
        return new ResponseEntity<CartItemResponse>(cartItemService.addCartItem(cartItemRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CartItemResponse>> getCartItems() {
        return ResponseEntity.ok(cartItemService.getCartItems());
    }

    @GetMapping("/{user-id}/{product-id}")
    public ResponseEntity<CartItemResponse> findById(@RequestParam(name = "user-id") long userId,
                                                     @RequestParam(name = "product-id") long productId) {
        return ResponseEntity.ok(cartItemService.getCartItem(userId, productId));
    }

    @PutMapping
    public ResponseEntity<CartItemResponse> updateCartItem(@RequestBody CartItemRequest cartItemRequest) {
        return new ResponseEntity<CartItemResponse>(
                cartItemService.updateCartItem(cartItemRequest),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{user-id}/{product-id}")
    public ResponseEntity<String> deleteCartItem(@RequestParam(name = "user-idd") long userId,
                                                 @RequestParam(name = "product-id") long productId) {
        cartItemService.deleteCartItem(userId, productId);
        return new ResponseEntity<String>("CartItem deleted successfully!", HttpStatus.ACCEPTED);
    }
}
