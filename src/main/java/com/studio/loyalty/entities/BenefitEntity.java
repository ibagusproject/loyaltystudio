package com.studio.loyalty.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "benefits")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BenefitEntity extends BaseEntity {

    @NotEmpty
    private String discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rank_benefits")
    @JsonIgnore
    @ToString.Exclude
    private RankEntity rank;

}
