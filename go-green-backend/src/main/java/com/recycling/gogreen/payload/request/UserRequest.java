package com.recycling.gogreen.payload.request;

import com.recycling.gogreen.model.cart.CartItem;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "Username can't be empty")
    @Size(max = 100, message = "Username max characters is 35")
    private String username;

    @NotBlank(message = "User phone can't be empty")
    @Size(max = 100, message = "Password max characters is 100")
    private String password;

    @NotBlank(message = "User email can't be empty")
    @Size(max = 100, message = "Email max characters is 100")
    private String email;

    @NotBlank(message = "Name can't be empty")
    @Size(max = 100, message = "Name max characters is 100")
    private String name;

    @NotBlank(message = "User address can't be empty")
    @Size(max = 100, message = "Address max characters is 100")
    private String address;

    @NotBlank(message = "User phone can't be empty")
    @Size(max = 100, message = "Phone max characters is 100")
    private String phone;

    private List<CartItem> cartItems;
}
