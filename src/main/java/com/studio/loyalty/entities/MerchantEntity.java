package com.studio.loyalty.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "merchants")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MerchantEntity extends BaseEntity {

    @NotEmpty
    private String merchantname;

    @NotEmpty
    @Column(unique = true)
    private String phone;

    @NotEmpty
    private String address;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<VoucherEntity> vouchers;
}
