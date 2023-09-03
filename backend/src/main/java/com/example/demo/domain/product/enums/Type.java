package com.example.demo.domain.product.enums;

import lombok.Getter;

@Getter
public enum Type {
    CUSTOMER("customer"), INDUSTRY("industry"), SERVICE("service");
    private final String type;
    Type(String type){
        this.type = type;
    }

}
