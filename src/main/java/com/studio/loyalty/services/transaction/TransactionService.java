package com.studio.loyalty.services.transaction;

import com.studio.loyalty.dtos.TransactionDto;

import java.sql.SQLException;

public interface TransactionService {

    Object getAll();

    Object getOne(String id);

    Object save(TransactionDto transaction) throws SQLException;

    Object update(TransactionDto transaction, String id);

    Object delete(String id) throws SQLException;

}
