package com.studio.loyalty.dtos;

import com.studio.loyalty.entities.BaseEntity;
import com.studio.loyalty.entities.EnumEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Getter
@Setter
@Validated
@RequiredArgsConstructor
public class RoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private EnumEntity.ROLES rolename;
}
