package com.groupeisi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @NotNull(message = "The firstname can't be null!")
    private String firstName;
    private String lastName;
    @NotNull(message = "The email can't be null!")
    private String email;
    @NotNull(message = "The password can't be null, required!")
    private String password;
}
