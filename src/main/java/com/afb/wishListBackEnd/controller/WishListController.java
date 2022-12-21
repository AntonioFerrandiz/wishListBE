package com.afb.wishListBackEnd.controller;

import com.afb.wishListBackEnd.domain.dto.WishList.CreateWishListResource;
import com.afb.wishListBackEnd.domain.dto.WishList.GetAllWishListResource;
import com.afb.wishListBackEnd.domain.dto.WishList.GetWishListResource;
import com.afb.wishListBackEnd.domain.model.WishList;
import com.afb.wishListBackEnd.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/wishList")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @PostMapping
    public ResponseEntity<CreateWishListResource> save(@Valid
                                                       @RequestBody
                                                       CreateWishListResource resource,
                                                       UriComponentsBuilder uriComponentsBuilder){
        WishList wishList = wishListService.save(resource);
        URI uri = uriComponentsBuilder.path("/wishList/{id}").buildAndExpand(wishList.getId()).toUri();
        return ResponseEntity.created(uri).body(new CreateWishListResource(wishList));
    }

    @GetMapping()
    public ResponseEntity<List<GetAllWishListResource>> getAllWishLists(){
        return ResponseEntity.ok(wishListService.getAllWishListResourceList());
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<GetWishListResource>> getWishListByUser(@PathVariable Long userId){
        return ResponseEntity.ok(wishListService.getWishListByUser(userId));
    }

    @DeleteMapping("delete/{wishListId}/{userId}")
    public ResponseEntity removeProductFromWishList(@PathVariable Long wishListId, @PathVariable Long userId){
        wishListService.removeProductFromWishList(wishListId,userId);
        return ResponseEntity.ok().build();
    }
}
