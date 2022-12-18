package com.studio.loyalty.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Getter
@Setter
@Validated
@RequiredArgsConstructor
public class BenefitDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String discount;
    private String rank;
    private String transaction;
}
