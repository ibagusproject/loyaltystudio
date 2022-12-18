package com.studio.loyalty.services.voucher;

import com.studio.loyalty.dtos.VoucherDto;

import java.sql.SQLException;

public interface VoucherService {

    Object getAll();

    Object getOne(String id);

    Object save(VoucherDto role) throws SQLException;

    Object update(VoucherDto role, String id);

    Object delete(String id) throws SQLException;

}
