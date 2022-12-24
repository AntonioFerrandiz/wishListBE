package com.afb.wishListBackEnd.domain.repository;

import com.afb.wishListBackEnd.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
