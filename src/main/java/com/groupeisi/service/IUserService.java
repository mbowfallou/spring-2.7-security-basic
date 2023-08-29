package com.groupeisi.service;

import com.groupeisi.dto.AppUser;
import com.groupeisi.entity.UserEntity;

public interface IUserService {
    UserEntity saveUser(AppUser appUserDto);
}
