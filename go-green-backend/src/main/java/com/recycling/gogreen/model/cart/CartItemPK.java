package com.recycling.gogreen.model.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recycling.gogreen.model.Product;
import com.recycling.gogreen.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CartItemPK implements Serializable {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;
}
