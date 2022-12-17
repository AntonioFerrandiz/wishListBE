package com.afb.wishListBackEnd.domain.dto.WishList;

import com.afb.wishListBackEnd.domain.model.Product;
import com.afb.wishListBackEnd.domain.model.User;
import com.afb.wishListBackEnd.domain.model.WishList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateWishListResource {
    private Long id;

    private LocalDateTime dateCreated;


    private Long userId;
    private Long productId;

    public CreateWishListResource(WishList wishList){
        this.id = wishList.getId();
        this.dateCreated = wishList.getDateCreated();
    }

    public WishList convert(Optional<Product> product, Optional<User> user){
        return new WishList(dateCreated, product,user);
    }
}
