package org.example.capstone1.Service;

import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.Merchant;

import org.example.capstone1.Repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final MerchantRepository merchants;

    public List<Merchant> getMerchants() {
        return merchants.findAll();
    }

    public void addMerchants(Merchant merchant) {
        merchants.save(merchant);
    }

    public Boolean updateMerchants(Integer id, Merchant merchant) {
        Merchant merchant1=merchants.getById(id);
        if (merchant1==null){
            return false;
        }
        merchant1.setName(merchant.getName());
        merchants.save(merchant1);
        return true;
    }

    public Boolean deleteMerchants(Integer id) {
        Merchant merchant1=merchants.getById(id);
        if (merchant1==null){
            return false;
        }
        merchants.delete(merchant1);
        return true;
    }



}
