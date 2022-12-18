package com.studio.loyalty.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ranks")
@Getter
@Setter
@ToString
public class RankEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private EnumEntity.RANK rankname = EnumEntity.RANK.SILVER;

    @OneToMany(mappedBy = "rank", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<UserEntity> users = new HashSet<>();

    @OneToMany(mappedBy = "rank", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<BenefitEntity> benefits = new HashSet<>();

}
