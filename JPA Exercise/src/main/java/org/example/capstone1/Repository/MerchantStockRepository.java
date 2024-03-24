package org.example.capstone1.Repository;

import org.example.capstone1.Model.MerchantStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantStockRepository extends JpaRepository<MerchantStock, Integer> {

    MerchantStock findByProductIDAndMerchantID(Integer productID, Integer merchantID);
}
