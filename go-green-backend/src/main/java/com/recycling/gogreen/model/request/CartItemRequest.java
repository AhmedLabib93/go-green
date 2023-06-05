package com.recycling.gogreen.model.request;

import com.recycling.gogreen.model.cart.CartItemPK;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemRequest {

    private CartItemPK cartItemPK;

    @NotEmpty
    private Date addDate;

    @NotEmpty
    @Min(0)
    private int quantity;
}
