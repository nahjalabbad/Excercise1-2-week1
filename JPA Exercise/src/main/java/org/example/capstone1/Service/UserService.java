package org.example.capstone1.Service;

import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.*;
import org.example.capstone1.Repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final MerchantStockRepository merchantStockRepository;
    private final ProductRepository productRepository;
    private final MerchantRepository merchantRepository;
    private final PurchaseHistoryRepository purchaseHistoryRepository;
    private final UserRepository userRepository;
    private final PurchaseHistoryService purchaseHistoryService; // Inject PurchaseHistoryService

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUsers(User user) {
        user.setPoints(25);
        userRepository.save(user);
    }

    public Boolean updateUsers(Integer id, User user) {
        User user1 = userRepository.getById(id);
        if (user1 == null) {
            return false;
        }
        user1.setBalance(user.getBalance());
        user1.setRole(user.getRole());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        userRepository.save(user1);
        return true;
    }

    public boolean deleteUsers(Integer id) {
        User user1 = userRepository.getById(id);
        if (user1 == null) {
            return false;
        }
        userRepository.delete(user1);
        return true;
    }

    public List<Object[]> buyProduct(Integer userID, Integer productID, Integer merchantID, Integer amount) {
        User user = userRepository.getById(userID);
        if (user == null) {
            return null;
        }

        Product product = productRepository.getById(productID);
        Merchant merchant = merchantRepository.getById(merchantID);

        if (product == null || merchant == null) {
            return null;
        }

        MerchantStock merchantStock = merchantStockRepository.findByProductIDAndMerchantID(productID, merchantID);
        if (merchantStock == null) {
            return null; // Merchant stock not found
        }

        int stock = merchantStock.getStock();
        if (stock >= amount && user.getBalance() >= product.getPrice()) {
            double totalPriceBeforeDiscount = product.getPrice() * amount;
            double discount = getDiscount(user);
            double discountedPrice = totalPriceBeforeDiscount * (1 - discount);

            int userPointsBeforeDeduction = user.getPoints();
            int deductedUserPoints = (int) (totalPriceBeforeDiscount / 10);
            int userPointsAfterDeduction = userPointsBeforeDeduction - deductedUserPoints;

            addPointsUser(user, discountedPrice);

            double newBalance = user.getBalance() - discountedPrice;
            user.setBalance(newBalance);
            userRepository.save(user);

            merchantStock.deductStock(amount);
            merchantStockRepository.save(merchantStock);

            PurchaseHistory purchaseHistoryRecord = new PurchaseHistory(productID, userID, product.getName(),
                    product.getPrice(), amount, LocalDate.now());
            purchaseHistoryService.addPurchaseRecord(purchaseHistoryRecord);


            return generatePurchaseInfoList(userPointsBeforeDeduction, deductedUserPoints,
                    userPointsAfterDeduction, discountedPrice, totalPriceBeforeDiscount, newBalance);
        } else {
            return null;
        }
    }

    private List<Object[]> generatePurchaseInfoList(int userPointsBeforeDeduction, int deductedUserPoints,
                                                    int userPointsAfterDeduction, double discountedPrice,
                                                    double totalPriceBeforeDiscount, double newBalance) {
        double discountPercentage = (double) deductedUserPoints / 10;
        double productPriceAfterDiscount = totalPriceBeforeDiscount - discountedPrice;
        double userNewBalance = newBalance;

        List<Object[]> result = new ArrayList<>();
        result.add(new Object[]{
                userPointsBeforeDeduction,
                deductedUserPoints,
                userPointsAfterDeduction,
                discountedPrice,
                totalPriceBeforeDiscount,
                productPriceAfterDiscount,
                userNewBalance
        });
        return result;
    }

    private double getDiscount(User user) {
        int points = user.getPoints();
        if (points >= 1000) {
            return 0.35;
        } else if (points >= 500) {
            return 0.25;
        } else if (points >= 100) {
            return 0.10;
        } else if (points >= 50) {
            return 0.05;
        } else {
            return 0;
        }
    }

    private void addPointsUser(User user, double totalPrice) {
        int addPoints = (int) (totalPrice / 10);
        user.setPoints(user.getPoints() + addPoints);
        userRepository.save(user);
    }
}


