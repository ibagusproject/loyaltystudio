package com.studio.loyalty.services.product;

import com.studio.loyalty.dtos.ProductDto;
import com.studio.loyalty.entities.ProductEntity;
import com.studio.loyalty.entities.TransactionEntity;
import com.studio.loyalty.repositories.ProductRepository;
import com.studio.loyalty.repositories.TransactionRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Object getAll() {
        return productRepository.findAll();
    }

    @Override
    public Object getOne(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Object save(ProductDto product) throws SQLException {
        try {
            TransactionEntity trx = transactionRepository.findById(product.getTransaction()).get();
            ProductEntity u = new ProductEntity();
            u.setProductname(product.getProductname());
            u.setPrice(product.getPrice());
            u.setDescription(product.getDescription());
            u.setImage(product.getImage());
            u.setTransaction(trx);
            return productRepository.save(u);
        } catch (ConstraintViolationException e) {
            throw new SQLException("Data sudah terdaftar");
        }
    }

    @Override
    public Object update(ProductDto product, String id) {
        // update belum berhasil
        ProductEntity u = productRepository.findById(id).get();
        return productRepository.save(u);
    }

    @Override
    public Object delete(String id) throws SQLException {
        try {
            productRepository.deleteById(id);
            return "Berhasil menghapus data";
        } catch (Exception e) {
            throw new SQLException("Data tidak ditemukan");
        }
    }
}
