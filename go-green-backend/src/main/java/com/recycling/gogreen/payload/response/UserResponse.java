package com.recycling.gogreen.payload.response;

import com.recycling.gogreen.model.cart.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String address;
    private String phone;
    private List<CartItem> cartItems;
    /*
    private final double price = getCartTotal();


    private double getCartTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getCartItemPK().getProduct().getPrice().doubleValue() * item.getQuantity();
        }
        return total;
    }

     */
}
