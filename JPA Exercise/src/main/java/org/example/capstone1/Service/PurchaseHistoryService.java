package org.example.capstone1.Service;

import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.PurchaseHistory;
import org.example.capstone1.Repository.PurchaseHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseHistoryService {
    private final PurchaseHistoryRepository purchaseHistoryRepository;

    public void addPurchaseRecord(PurchaseHistory purchaseRecord) {
        purchaseHistoryRepository.save(purchaseRecord);
    }

    public List<PurchaseHistory> getPurchaseHistoryByUserId(Integer userId) {
        return purchaseHistoryRepository.findByUserId(userId);
    }

    public List<PurchaseHistory> getPurchaseHistoryByProductId(Integer productId) {
        return purchaseHistoryRepository.findByProductId(productId);
    }
}
