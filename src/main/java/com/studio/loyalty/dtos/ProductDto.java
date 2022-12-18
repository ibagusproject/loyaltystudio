package com.studio.loyalty.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Validated
@RequiredArgsConstructor
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String productname;

    private BigDecimal price;

    private String description;

    private String image;

    private String transaction;
}
