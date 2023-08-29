package com.groupeisi.service;

import com.groupeisi.entity.RoleEntity;
import com.groupeisi.entity.UserEntity;
import com.groupeisi.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServices implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmailIgnoreCase(username);

        if(userEntity == null)
            throw new UsernameNotFoundException("Invalid username ou password !");

        return new User(userEntity.getEmail(), userEntity.getPassword(), mapRolesToAuthorities(userEntity.getRoles()));
    }

    private Collection<? extends SimpleGrantedAuthority> mapRolesToAuthorities(Collection<RoleEntity> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
