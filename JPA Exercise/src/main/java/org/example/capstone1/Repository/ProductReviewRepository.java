package org.example.capstone1.Repository;

import org.example.capstone1.Model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {
    List<ProductReview> findByProductNameIgnoreCase(String productName);
    List<ProductReview> findByProductId(Integer productId);
}
