package com.studio.loyalty;

import com.studio.loyalty.entities.EnumEntity;
import com.studio.loyalty.entities.RankEntity;
import com.studio.loyalty.entities.RoleEntity;
import com.studio.loyalty.repositories.RankRepository;
import com.studio.loyalty.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

@SpringBootApplication
public class LoyaltyStudioApplication implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RankRepository rankRepository;

    public static void main(String[] args) {
        SpringApplication.run(LoyaltyStudioApplication.class, args);
    }

    @Override
    public void run(String... args) {
        for (EnumEntity.ROLES role : EnumEntity.ROLES.values()) {
            if (roleRepository.existsByRolename(role)){
                continue;
            }
            RoleEntity r = new RoleEntity();
            r.setRolename(role);
            roleRepository.save(r);
        }

        for (EnumEntity.RANK rank : EnumEntity.RANK.values()) {
            if (rankRepository.existsByRankname(rank)){
                continue;
            }
            RankEntity r = new RankEntity();
            r.setRankname(rank);
            rankRepository.save(r);
        }
    }

}
