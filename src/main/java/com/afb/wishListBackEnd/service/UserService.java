package com.afb.wishListBackEnd.service;

import com.afb.wishListBackEnd.domain.dto.User.CreateUserResource;
import com.afb.wishListBackEnd.domain.model.User;
import com.afb.wishListBackEnd.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final String ENTITY = "Usuario";

    @Autowired
    private UserRepository userRepository;

    public User save (CreateUserResource resource){
        User user = resource.convert();
        return userRepository.save(user);
    }
}
