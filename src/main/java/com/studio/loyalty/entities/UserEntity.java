package com.studio.loyalty.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserEntity extends BaseEntity {

    @NotNull
    private Integer point = 0;

    @NotEmpty
    private String username;

    @NotEmpty
    @Column(unique = true)
    private String phone;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty
    @JsonIgnore
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ranks")
    @JsonIgnore
    @ToString.Exclude
    private RankEntity rank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_roles", nullable = false)
    @JsonIgnore
    @ToString.Exclude
    private RoleEntity role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<VoucherEntity> vouchers = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<TransactionEntity> transactions = new HashSet<>();

}
