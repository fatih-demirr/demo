package com.example.demo.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.NotBlank;


@Data
@Document(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    @NotBlank(message = "required")
    @Field("name")
    private String productName;
    @Field("desc")
    private String productDescription;
    @Field("type")
    private String productType;
    @Field("price")
    private Integer productPrice;
    @Field("image")
    private String productImagePath;
}
