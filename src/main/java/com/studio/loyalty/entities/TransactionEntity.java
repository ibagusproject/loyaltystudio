package com.studio.loyalty.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransactionEntity extends BaseEntity {

    @NotNull
    @Min(value = 1, message = "Minimal pembelian 1 pcs")
    private Integer quantity;

    @NotNull
    private BigDecimal total;

    @NotNull
    private Integer earning;

    @NotEmpty
    private EnumEntity.STATUS status = EnumEntity.STATUS.SUCCESS;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_transactions")
    @JsonIgnore
    @ToString.Exclude
    private UserEntity user;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<ProductEntity> products = new HashSet<>();
}
