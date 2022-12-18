package com.studio.loyalty.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EnumEntity.ROLES rolename = EnumEntity.ROLES.CUSTOMER;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<UserEntity> users = new HashSet<>();
}
