package com.groupeisi.service;

import com.groupeisi.dto.AppUser;
import com.groupeisi.entity.RoleEntity;
import com.groupeisi.entity.UserEntity;
import com.groupeisi.mapping.AppUserMapper;
import com.groupeisi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService implements IUserService{
    private UserRepository userRepository;
    private AppUserMapper userMapper;
    @Autowired     private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, AppUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserEntity saveUser(AppUser appUserDto){
        appUserDto.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
        UserEntity userEntity = userMapper.fromUserDto(appUserDto);
        userEntity.setRoles(Arrays.asList(new RoleEntity("ROLE_USER")));
        return userRepository.save(userEntity);
    }
}
