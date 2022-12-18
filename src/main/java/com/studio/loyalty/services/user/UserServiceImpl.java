package com.studio.loyalty.services.user;

import com.studio.loyalty.dtos.UserDto;
import com.studio.loyalty.entities.RankEntity;
import com.studio.loyalty.entities.RoleEntity;
import com.studio.loyalty.entities.UserEntity;
import com.studio.loyalty.repositories.RankRepository;
import com.studio.loyalty.repositories.RoleRepository;
import com.studio.loyalty.repositories.UserRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RankRepository rankRepository;

    @Override
    public Object getAll() {
        return userRepository.findAll();
    }

    @Override
    public Object getOne(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Object save(UserDto user) throws SQLException {
        try {
            RoleEntity role = roleRepository.findByRolename(user.getRolename()).get();
            RankEntity rank = rankRepository.findByRankname(user.getRankname()).get();
            UserEntity u = new UserEntity();
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            u.setEmail(user.getEmail());
            u.setPhone(user.getPhone());
            u.setRole(role);
            u.setRank(rank);
            return userRepository.save(u);
        } catch (ConstraintViolationException e) {
            throw new SQLException("Data sudah terdaftar");
        }
    }

    @Override
    public Object update(UserDto user, String id) {
        // update belum berhasil
        UserEntity u = userRepository.findById(id).get();
        return userRepository.save(u);
    }

    @Override
    public Object delete(String id) throws SQLException {
        try {
            userRepository.deleteById(id);
            return "Berhasil menghapus data";
        } catch (Exception e) {
            throw new SQLException("Data tidak ditemukan");
        }
    }
}
