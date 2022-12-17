package com.afb.wishListBackEnd.controller;

import com.afb.wishListBackEnd.domain.dto.Product.CreateProductResource;
import com.afb.wishListBackEnd.domain.dto.Product.GetProductResource;
import com.afb.wishListBackEnd.domain.model.Product;
import com.afb.wishListBackEnd.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<CreateProductResource> save(@Valid
                                                      @RequestBody
                                                      CreateProductResource resource,
                                                      UriComponentsBuilder uriComponentsBuilder){
        Product product = productService.save(resource);
        URI uri = uriComponentsBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new CreateProductResource(product));
    }

    @GetMapping
    public ResponseEntity<List<GetProductResource>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
