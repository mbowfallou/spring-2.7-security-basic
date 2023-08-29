package com.groupeisi.mapping;

import com.groupeisi.dto.AppRole;
import com.groupeisi.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppRoleMapper {
    AppRole toRoleDto(RoleEntity roleEntity);
    RoleEntity fromRoleDto(AppRole roleDto);
}
