package org.example.capstone1.Service;


import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.MerchantStock;
import org.example.capstone1.Repository.MerchantRepository;
import org.example.capstone1.Repository.MerchantStockRepository;
import org.example.capstone1.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class MerchantStockService {
    private final MerchantStockRepository merchantStocks;
    private final MerchantRepository merchantRepository;
    private final ProductRepository productRepository;
    public List<MerchantStock> getMerchantStocks() {
        return merchantStocks.findAll();
    }

    public Boolean addMerchantStocks(MerchantStock merchantStock) {
        if (merchantRepository.existsById(merchantStock.getMerchantID())&&productRepository.existsById(merchantStock.getProductID())){
            merchantStocks.save(merchantStock);
            return true;
        }
        return false;
    }



    public Boolean updateMerchantStocks(Integer id, MerchantStock merchantStock) {
        MerchantStock ms=merchantStocks.getById(id);
        if (ms==null){
            return false;
        }
        ms.setStock(merchantStock.getStock());
        ms.setMerchantID(merchantStock.getMerchantID());
        ms.setProductID(merchantStock.getProductID());
        merchantStocks.save(ms);
        return true;
    }

    public Boolean deleteMerchantStocks(Integer id) {
        MerchantStock ms=merchantStocks.getById(id);
        if (ms==null){
            return false;
        }
        merchantStocks.delete(ms);
        return true;
    }

    public Boolean addStock(Integer merchentStockID, int amount) {
        MerchantStock merchantStock = merchantStocks.getById(merchentStockID);
        if (merchantStock!=null) {
                if (merchantStock.getStock() > amount) {
                    merchantStock.setStock(merchantStock.getStock() + amount);
                    merchantStocks.save(merchantStock);
                    return true;
                }

            }

        return false;
    }

}


