package com.recycling.gogreen.payload.response;

import com.recycling.gogreen.model.cart.CartItemPK;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponse {

    private CartItemPK cartItemPK;
    private Date addDate;
    private int quantity;
}
