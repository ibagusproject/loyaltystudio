package com.studio.loyalty.services.transaction;

import com.studio.loyalty.dtos.TransactionDto;
import com.studio.loyalty.entities.*;
import com.studio.loyalty.repositories.*;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Object getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Object getOne(String id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Object save(TransactionDto transaction) throws SQLException {
        try {
            Set<ProductEntity> products = new HashSet<>();
            for (String id : transaction.getProducts()){
                products.add(getProduct(id));
            }
            UserEntity user = userRepository.findById(transaction.getUser()).get();
            TransactionEntity u = new TransactionEntity();
            u.setQuantity(transaction.getQuantity());
            u.setTotal(transaction.getTotal());
            u.setUser(user);
            u.setProducts(products);
            return transactionRepository.save(u);
        } catch (ConstraintViolationException e) {
            throw new SQLException("Data sudah terdaftar");
        }
    }

    @Override
    public Object update(TransactionDto transaction, String id) {
        // update belum berhasil
        TransactionEntity u = transactionRepository.findById(id).get();
        return transactionRepository.save(u);
    }

    @Override
    public Object delete(String id) throws SQLException {
        try {
            transactionRepository.deleteById(id);
            return "Berhasil menghapus data";
        } catch (Exception e) {
            throw new SQLException("Data tidak ditemukan");
        }
    }

    private ProductEntity getProduct(String id){
        return productRepository.findById(id).get();
    }
}
