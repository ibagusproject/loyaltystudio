package com.studio.loyalty.dtos;

import com.studio.loyalty.entities.EnumEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@RequiredArgsConstructor
public class VoucherDto {

    private static final long serialVersionUID = 1L;

    private String id;

    private String vouchername;

    private Integer voucherpoint;

    private String vouchercode;

    private EnumEntity.STATUS statusvoucher;

    private String merchant;

    private String user;
}
