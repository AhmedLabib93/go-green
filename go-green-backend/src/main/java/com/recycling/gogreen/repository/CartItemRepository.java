package com.recycling.gogreen.repository;

import com.recycling.gogreen.model.Product;
import com.recycling.gogreen.model.User;
import com.recycling.gogreen.model.cart.CartItem;
import com.recycling.gogreen.model.cart.CartItemPK;
import com.recycling.gogreen.model.response.CartItemResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemPK> {

}
