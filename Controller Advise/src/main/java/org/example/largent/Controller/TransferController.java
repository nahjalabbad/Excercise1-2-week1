package org.example.largent.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.largent.API.ApiResponse;
import org.example.largent.Model.Transfer;
import org.example.largent.Service.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    Logger logger= LoggerFactory.getLogger(TransferController.class);

    @GetMapping("/get")
    public ResponseEntity getTransfers(){
        logger.info("inside get transfer");
        return ResponseEntity.ok(transferService.getTransfers());
    }

    @PostMapping("/add")
    public ResponseEntity addPurchHistory(@RequestBody @Valid Transfer transfer){
        logger.info("inside add transfer");
        transferService.addTransfer(transfer);
        return ResponseEntity.ok().body(new ApiResponse("Transfer has been made"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTransfer(@PathVariable Integer id, @RequestBody @Valid Transfer transfer){
        logger.info("inside update transfer");
        transferService.updateTransfer(id,transfer);
        return ResponseEntity.ok().body(new ApiResponse("Transfer has been updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTransfer(@PathVariable Integer id){
        logger.info("inside delete transfer");
        transferService.deleteTransfer(id);
        return ResponseEntity.ok().body(new ApiResponse("Transfer has been deleted"));
    }

    //                  EXTRA

    @PostMapping("/transfer-currency/{transferId}/{currency}/{amount}")
    public ResponseEntity transferCurrency(@PathVariable Integer transferId,@PathVariable String currency,@PathVariable Double amount){
        logger.info("inside transfer in another currency");
        transferService.transferCurrency(transferId,currency, amount);
        return ResponseEntity.ok().body(new ApiResponse("Transfer with the currency "+currency+" has been made"));
    }
}
