package com.groupeisi.mapping;

import com.groupeisi.dto.AppUser;
import com.groupeisi.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    AppUser toUserDto(UserEntity userEntity);
    UserEntity fromUserDto(AppUser userDto);
}
