package com.recycling.gogreen.model.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recycling.gogreen.model.Product;
import com.recycling.gogreen.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_item")
public class CartItem {

    @JsonIgnore
    @EmbeddedId
    private CartItemPK cartItemPK;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date addDate;

    @Column(nullable = false)
    private int quantity;
}
