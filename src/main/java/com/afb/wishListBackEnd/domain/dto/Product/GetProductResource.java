package com.afb.wishListBackEnd.domain.dto.Product;

import com.afb.wishListBackEnd.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResource {
    private Long id;

    private String name;

    private Integer unitPrice;

    private String category;

    private String image;

    public GetProductResource(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.unitPrice = product.getUnitPrice();
        this.category = product.getCategory();
        this.image = product.getImage();
    }

    public static List<GetProductResource> convert(List<Product> products){
        return products.stream().map(GetProductResource::new).collect(Collectors.toList());
    }
}

