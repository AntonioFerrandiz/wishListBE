package com.afb.wishListBackEnd.domain.repository;

import com.afb.wishListBackEnd.domain.dto.WishList.GetAllWishListResource;
import com.afb.wishListBackEnd.domain.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList,Long> {
    List<WishList> getWishListByUser_Id(Long userId);

    List<WishList> getWishListByUser_IdAndProduct_Id(Long userId, Long ProductId);

//    select wl.user_id, u.username, count(wl.user_id)
//    from wish_lists wl join users u on wl.user_id = u.id
//    group by wl.user_id, u.username
    @Query(
         value = "select wl.user_id, u.username, u.profile_picture, count(wl.user_id) from wish_lists wl join users u on wl.user_id = u.id group by wl.user_id, u.username, u.profile_picture",
         nativeQuery = true
    )
    List<GetAllWishListResource> getAllWishListInDb();
}
