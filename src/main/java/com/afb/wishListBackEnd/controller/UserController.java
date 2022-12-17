package com.afb.wishListBackEnd.controller;


import com.afb.wishListBackEnd.domain.dto.User.CreateUserResource;
import com.afb.wishListBackEnd.domain.model.User;
import com.afb.wishListBackEnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping

    public ResponseEntity<CreateUserResource> save(@Valid
                                                   @RequestBody
                                                   CreateUserResource resource,
                                                   UriComponentsBuilder uriComponentsBuilder){
        User user = userService.save(resource);
        URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new CreateUserResource(user));
    }
}
