package com.afb.wishListBackEnd.domain.repository;

import com.afb.wishListBackEnd.domain.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList,Long> {
    List<WishList> getWishListByUser_Id(Long userId);

    List<WishList> getWishListByUser_IdAndProduct_Id(Long userId, Long ProductId);
}
