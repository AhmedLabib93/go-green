package com.recycling.gogreen.payload.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @NotBlank(message = "Product phone can't be empty")
    @Max(128)
    private String name;

    @NotBlank(message = "Product phone can't be empty")
    @Max(4000)
    private String description;

    @NotBlank(message = "Product price can't be empty")
    private BigDecimal price;

    private byte[] image;
}
