package com.afb.wishListBackEnd.service;

import com.afb.wishListBackEnd.domain.dto.WishList.CreateWishListResource;
import com.afb.wishListBackEnd.domain.dto.WishList.GetAllWishListResource;
import com.afb.wishListBackEnd.domain.dto.WishList.GetWishListResource;
import com.afb.wishListBackEnd.domain.model.Product;
import com.afb.wishListBackEnd.domain.model.User;
import com.afb.wishListBackEnd.domain.model.WishList;
import com.afb.wishListBackEnd.domain.repository.ProductRepository;
import com.afb.wishListBackEnd.domain.repository.UserRepository;
import com.afb.wishListBackEnd.domain.repository.WishListRepository;
import com.afb.wishListBackEnd.shared.exception.EmptyResourceException;
import com.afb.wishListBackEnd.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WishListService {
    private static final String ENTITY = "WishList";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WishListRepository wishListRepository;

    public WishList save(CreateWishListResource resource){
        Optional<User> user = userRepository.findById(resource.getUserId());
        Optional<Product> product = productRepository.findById(resource.getProductId());

        if(user.isEmpty()){
            throw new ResourceNotFoundException("User", resource.getProductId());
        }
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product", resource.getProductId());
        }

        List<WishList> wishLists;
        wishLists = wishListRepository.getWishListByUser_IdAndProduct_Id(resource.getUserId(), resource.getProductId());


        if(!wishLists.isEmpty()){
            throw new EmptyResourceException(ENTITY);
        }

        WishList wishList = resource.convert(product, user);
        return wishListRepository.save(wishList);
    }

    public void removeProductFromWishList(Long wishListId, Long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User", userId);
        }

        Optional<WishList> wishList = wishListRepository.findById(wishListId);
        if(wishList.isEmpty()){
            throw new ResourceNotFoundException("Wishlist", wishListId);
        }
        if(!Objects.equals(wishList.get().getUser().getId(), userId)){
            throw new ResourceNotFoundException(wishListId);
        }
        wishListRepository.deleteById(wishListId);
    }
    public List<GetWishListResource> getWishListByUser(Long userId){
        List<WishList> wishLists;
        wishLists = wishListRepository.getWishListByUser_Id(userId);
        return GetWishListResource.convert(wishLists);
    }


    public List<GetAllWishListResource> getAllWishListResourceList(){
        List<GetAllWishListResource> getAllWishListResources;
        getAllWishListResources = wishListRepository.getAllWishListInDb();
        return getAllWishListResources;
    }
}
