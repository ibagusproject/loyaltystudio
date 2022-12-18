package com.studio.loyalty.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductEntity extends BaseEntity {

    @NotEmpty
    private String productname;

    @NotEmpty
    private BigDecimal price;

    @NotEmpty
    private String description;

    @NotEmpty
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_products")
    @JsonIgnore
    @ToString.Exclude
    private TransactionEntity transaction;
}
