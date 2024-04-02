package org.example.largent.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.largent.API.ApiResponse;
import org.example.largent.Model.Product;
import org.example.largent.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    Logger logger= LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/get")
    public ResponseEntity getAllProducts(){
        logger.info("inside get all products");
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product){
        logger.info("inside add product");
        productService.addProduct(product);
        return ResponseEntity.ok().body(new ApiResponse("Product has been added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updatePurchase(@PathVariable Integer id, @RequestBody @Valid Product product){
        logger.info("inside update product");
        productService.updateProduct(id, product);
        return ResponseEntity.ok().body(new ApiResponse("Product has been updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        logger.info("inside delete product");
        productService.deleteProduct(id);
        return ResponseEntity.ok().body(new ApiResponse("Product has been deleted"));

    }


    //                    EXTRA
    @PostMapping("/buy-product/{userId}/{productId}/{amount}")
    public ResponseEntity buyProduct(@PathVariable Integer userId, @PathVariable Integer productId, @PathVariable Integer amount){
        logger.info("inside buy product");
        productService.buyProduct(userId, productId, amount);
        return ResponseEntity.ok().body(new ApiResponse("Thank you for your purchase"));

    }

}
