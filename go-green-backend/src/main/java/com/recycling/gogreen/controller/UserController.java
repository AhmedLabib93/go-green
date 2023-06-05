package com.recycling.gogreen.controller;

import com.recycling.gogreen.model.cart.CartItem;
import com.recycling.gogreen.payload.request.UserRequest;
import com.recycling.gogreen.payload.response.UserResponse;
import com.recycling.gogreen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/gogreen/v1/users/")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<UserResponse>(userService.addUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestParam(name = "username") String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @GetMapping("/{username}/cart")
    public ResponseEntity<List<CartItem>> findUserCarts(@RequestParam(name = "username") String username) {
        UserResponse userResponse = userService.getUserByUsername(username);
        return ResponseEntity.ok(userResponse.getCartItems());
    }

    @PutMapping("/{user-id}")
    public ResponseEntity<UserResponse> updateUser(@RequestParam(name = "user-id") long id,
                                                   @RequestBody UserRequest userRequest) {
        return new ResponseEntity<UserResponse>(
                userService.updateUser(id, userRequest),
                HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<String> deleteUser(@RequestParam(name = "user-id") long id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted successfully!", HttpStatus.ACCEPTED);
    }
}
