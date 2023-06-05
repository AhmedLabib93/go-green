package com.recycling.gogreen.repository;

import com.recycling.gogreen.model.cart.CartItem;
import com.recycling.gogreen.model.cart.CartItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemPK> {

}
