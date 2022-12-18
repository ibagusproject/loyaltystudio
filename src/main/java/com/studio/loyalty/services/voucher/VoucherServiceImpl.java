package com.studio.loyalty.services.voucher;

import com.studio.loyalty.dtos.VoucherDto;
import com.studio.loyalty.entities.MerchantEntity;
import com.studio.loyalty.entities.UserEntity;
import com.studio.loyalty.entities.VoucherEntity;
import com.studio.loyalty.repositories.MerchantRepository;
import com.studio.loyalty.repositories.UserRepository;
import com.studio.loyalty.repositories.VoucherRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Object getAll() {
        return voucherRepository.findAll();
    }

    @Override
    public Object getOne(String id) {
        return voucherRepository.findById(id);
    }

    @Override
    public Object save(VoucherDto voucher) throws SQLException {
        try {
            MerchantEntity merchant = merchantRepository.findById(voucher.getMerchant()).get();
            UserEntity user = userRepository.findById(voucher.getUser()).get();
            VoucherEntity u = new VoucherEntity();
            u.setVouchername(voucher.getVouchername());
            u.setVoucherpoint(voucher.getVoucherpoint());
            u.setVouchercode(voucher.getVouchercode());
            u.setStatusvoucher(voucher.getStatusvoucher());
            u.setMerchant(merchant);
            u.setUser(user);
            return voucherRepository.save(u);
        } catch (ConstraintViolationException e) {
            throw new SQLException("Data sudah terdaftar");
        }
    }

    @Override
    public Object update(VoucherDto role, String id) {
        // update belum berhasil
        VoucherEntity u = voucherRepository.findById(id).get();
        return voucherRepository.save(u);
    }

    @Override
    public Object delete(String id) throws SQLException {
        try {
            voucherRepository.deleteById(id);
            return "Berhasil menghapus data";
        } catch (Exception e) {
            throw new SQLException("Data tidak ditemukan");
        }
    }
}
