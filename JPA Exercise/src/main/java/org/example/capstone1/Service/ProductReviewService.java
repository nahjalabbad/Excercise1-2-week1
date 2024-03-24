package org.example.capstone1.Service;

import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.Product;
import org.example.capstone1.Model.ProductReview;
import org.example.capstone1.Model.User;
import org.example.capstone1.Repository.ProductRepository;
import org.example.capstone1.Repository.ProductReviewRepository;
import org.example.capstone1.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductReviewService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductReviewRepository reviews;

    public List<ProductReview> getReviews() {
        return reviews.findAll();
    }


    public Integer addReview(ProductReview review) {
        Product product = productRepository.getById(review.getProductId());
        if (productRepository.existsById(review.getProductId()) && userRepository.existsById(review.getUserId())) {
            if (product != null && product.hasSameName(review.getProductName())) {
                reviews.save(review);
                return 1;
            }
        }
        if (!product.hasSameName(review.getProductName())){
            return 2;
        }
        return 0;
    }

    public Boolean updateReviews(Integer reviewid, ProductReview review) {
        ProductReview review1=reviews.getById(reviewid);
        if (review1==null){
            return false;
        }
        review1.setReviewComment(review.getReviewComment());
        review1.setProductId(review.getProductId());
        review1.setRating(review.getRating());
        review1.setUserId(review.getUserId());
        reviews.save(review1);
        return true;
    }

    public Boolean deleteReviews(Integer reviewid) {
        ProductReview review1=reviews.getById(reviewid);
        if (review1==null){
            return false;
        }
        reviews.delete(review1);
        return true;
    }



    public List<ProductReview> getProductReviews(Integer productId) {

        return reviews.findByProductId(productId);
    }

    public Double getAvgRating(String productName) {

        List<ProductReview> productReviews = reviews.findByProductNameIgnoreCase(productName);
        if (productReviews.isEmpty()) {
            return null;
        }

        double sum = 0.0;
        for (ProductReview review : productReviews) {
            sum += review.getRating();
        }
        return sum / productReviews.size();
    }
}
