package org.example.largent.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.largent.API.ApiResponse;
import org.example.largent.Model.PurchaseHistory;
import org.example.largent.Service.PurchaseHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/purchase-history")
@RequiredArgsConstructor
public class PurchaseHistoryController {
    private final PurchaseHistoryService purchaseHistoryService;
    Logger logger= LoggerFactory.getLogger(PurchaseHistoryController.class);


    @GetMapping("/get")
    public ResponseEntity getAllPurchHistory(){
        logger.info("inside get all delete purchase history");
        return ResponseEntity.ok(purchaseHistoryService.getAllPurchaseHistory());
    }

    @PostMapping("/add")
    public ResponseEntity addPurchHistory(@RequestBody @Valid PurchaseHistory history){
        logger.info("inside add purchase history");
        purchaseHistoryService.addPurchHistory(history);
        return ResponseEntity.ok().body(new ApiResponse("Product history has been added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updatePurchHistory(@PathVariable Integer id, @RequestBody @Valid PurchaseHistory history){
        logger.info("inside update purchase history");
        purchaseHistoryService.updatePurchHistory(id,history);
        return ResponseEntity.ok().body(new ApiResponse("Product history information has been updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePurchHistory(@PathVariable Integer id){
        logger.info("inside delete purchase history");
        purchaseHistoryService.deletePurchHistory(id);
        return ResponseEntity.ok().body(new ApiResponse("Product history information has been deleted"));

    }

    //                      EXTRA

    @GetMapping("/get-duration/{userId}/{duration}")
    public ResponseEntity getPurchases(@PathVariable Integer userId, @PathVariable String duration){
        logger.info("inside get all purchases");
        return ResponseEntity.ok().body(purchaseHistoryService.getPurchases(userId, duration));

    }


}
