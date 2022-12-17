package com.afb.wishListBackEnd.domain.repository;

import com.afb.wishListBackEnd.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
