package com.recycling.gogreen.model.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
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
public class ProductRequest {

    @NotBlank
    @Max(128)
    private String name;

    @NotBlank
    @Max(4000)
    private String description;

    @NotBlank
    private double price;

    @NotEmpty
    private Date addDate;

    private byte[] image;
}
