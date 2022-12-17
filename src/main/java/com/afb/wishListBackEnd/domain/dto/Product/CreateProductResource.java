package com.afb.wishListBackEnd.domain.dto.Product;

import com.afb.wishListBackEnd.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductResource {
    private Long id;
    @NotNull
    @NotBlank
    private String name;

    private Integer unitPrice;

    @NotNull
    @NotBlank
    private String category;

    private String image;

    public CreateProductResource(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.unitPrice = product.getUnitPrice();
        this.category = product.getCategory();
        this.image = product.getImage();
    }
    public Product convert(){
        return new Product(name,unitPrice,category,image);
    }
}
