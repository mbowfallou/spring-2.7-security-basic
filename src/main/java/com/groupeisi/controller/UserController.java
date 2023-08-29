package com.groupeisi.controller;

import com.groupeisi.dto.AppUser;
import com.groupeisi.entity.UserEntity;
import com.groupeisi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public AppUser appUser(){
        return new AppUser();
    }

    @GetMapping("/registration")
    public String registrationForm(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") AppUser appUser){
        UserEntity userEntity = userService.saveUser(appUser);
        if(userEntity.getId() > 0)
            return "redirect:/registration?success";
        else
            return "redirect:/registration?failed";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
