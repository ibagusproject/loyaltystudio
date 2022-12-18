package com.studio.loyalty.services.product;

import com.studio.loyalty.dtos.ProductDto;

import java.sql.SQLException;

public interface ProductService {

    Object getAll();

    Object getOne(String id);

    Object save(ProductDto user) throws SQLException;

    Object update(ProductDto role, String id);

    Object delete(String id) throws SQLException;

}
