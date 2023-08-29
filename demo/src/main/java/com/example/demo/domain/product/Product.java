package com.example.demo.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.demo.domain.product.enums.Type;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;


@Data
@Document(collation = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    @NotBlank(message = "required")
    private String productName;
    private String productDescription;
    private String type;
    private Integer productPrice;
    private String productImagePath;
}
