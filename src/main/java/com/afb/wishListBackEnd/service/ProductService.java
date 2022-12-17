package com.afb.wishListBackEnd.service;

import com.afb.wishListBackEnd.domain.dto.Product.CreateProductResource;
import com.afb.wishListBackEnd.domain.dto.Product.GetProductResource;
import com.afb.wishListBackEnd.domain.model.Product;
import com.afb.wishListBackEnd.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static final String ENTITY = "Producto";

    @Autowired
    private ProductRepository productRepository;

    public Product save(CreateProductResource resource){
        Product product = resource.convert();
        return productRepository.save(product);
    }

    public List<GetProductResource> getAllProducts(){
        List<Product> products;
        products = productRepository.findAll();
        return GetProductResource.convert(products);
    }
}
