package com.groupeisi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRole {
    @NotNull(message = "The name can't be null!")
    private String name;
}
