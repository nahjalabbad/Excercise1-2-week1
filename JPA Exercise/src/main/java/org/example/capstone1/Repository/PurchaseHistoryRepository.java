package org.example.capstone1.Repository;

import org.example.capstone1.Model.PurchaseHistory;
import org.example.capstone1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Integer> {
    List<PurchaseHistory> findByUserId(Integer userId);
    List<PurchaseHistory> findByProductId(Integer productId);

    List<User> userId(Integer userId);
}
