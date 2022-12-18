package com.studio.loyalty.dtos;

import com.studio.loyalty.entities.EnumEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Validated
@RequiredArgsConstructor
public class TransactionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer quantity;

    private BigDecimal total;

    private Integer earning;

    private EnumEntity.STATUS status;

    private String user;

    private List<String> products;
}
