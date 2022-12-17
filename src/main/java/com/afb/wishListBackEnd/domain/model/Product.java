package com.afb.wishListBackEnd.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Parameter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "100000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    private Integer unitPrice;

    @NotNull
    @NotBlank
    private String category;

    @Column(name = "image", columnDefinition = "text")
    private String image;

    public Product(String name, Integer unitPrice, String category, String image) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.category = category;
        this.image = image;
    }
}
