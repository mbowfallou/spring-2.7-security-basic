package com.groupeisi.controller;

import com.groupeisi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
}
