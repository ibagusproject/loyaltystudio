package com.studio.loyalty.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "vouchers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class VoucherEntity extends BaseEntity {

    @NotEmpty
    private String vouchername;

    @NotEmpty
    private Integer voucherpoint;

    @NotEmpty
    private String vouchercode;

    @NotEmpty
    private EnumEntity.STATUS statusvoucher = EnumEntity.STATUS.UNUSED;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_vouchers")
    @JsonIgnore
    @ToString.Exclude
    private MerchantEntity merchant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_vouchers", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private UserEntity user;
}
