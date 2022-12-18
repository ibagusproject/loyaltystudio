package com.studio.loyalty.services.user;

import com.studio.loyalty.dtos.UserDto;
import com.studio.loyalty.entities.UserEntity;

import java.sql.SQLException;

public interface UserService {

    Object getAll();

    Object getOne(String id);

    Object save(UserDto user) throws SQLException;

    Object update(UserDto role, String id);

    Object delete(String id) throws SQLException;

}
