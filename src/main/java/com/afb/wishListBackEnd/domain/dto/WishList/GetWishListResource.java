package com.afb.wishListBackEnd.domain.dto.WishList;

import com.afb.wishListBackEnd.domain.model.Product;
import com.afb.wishListBackEnd.domain.model.WishList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetWishListResource {
    private Long id;

    private LocalDateTime dateCreated;

    private Product product;
    private String username;

    public GetWishListResource(WishList wishList){
        this.id = wishList.getId();
        this.dateCreated = wishList.getDateCreated();
        this.product = wishList.getProduct();
        this.username = wishList.getUser().getUsername();
    }

    public static List<GetWishListResource> convert(List<WishList> wishLists){
        return wishLists.stream().map(GetWishListResource::new).collect(Collectors.toList());
    }
}
