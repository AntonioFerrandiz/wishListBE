package com.afb.wishListBackEnd.domain.repository;

import com.afb.wishListBackEnd.domain.dto.User.GetUserResource;
import com.afb.wishListBackEnd.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    GetUserResource searchUserByUsername(String username);
}
