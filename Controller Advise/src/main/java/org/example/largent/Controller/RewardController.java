package org.example.largent.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.largent.API.ApiResponse;
import org.example.largent.Model.Reward;
import org.example.largent.Service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reward")
@RequiredArgsConstructor
public class RewardController {

    private final RewardService rewardService;
    Logger logger= LoggerFactory.getLogger(RewardController.class);

    @GetMapping("/get")
    public ResponseEntity getAllRewards(){
        logger.info("inside get all rewards");
        return ResponseEntity.ok().body(rewardService.getAllRewards());
    }

    @PostMapping("/add")
    public ResponseEntity addReward(@RequestBody @Valid Reward reward){
        logger.info("inside add rewards");
        rewardService.addReward(reward);
        return ResponseEntity.ok().body(new ApiResponse("Reward has been made"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateReward(@PathVariable Integer id, @RequestBody @Valid Reward reward){
        logger.info("inside update rewards");
        rewardService.updateReward(id,reward);
        return ResponseEntity.ok().body(new ApiResponse("Reward has been updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteReward(@PathVariable Integer id){
        logger.info("inside delete rewards");
        rewardService.deleteReward(id);
        return ResponseEntity.ok().body(new ApiResponse("Reward has been deleted"));

    }

    //                    EXTRA

    @PostMapping("/redeem/{userId}/{rewardId}")
    public ResponseEntity redeemPoints(@PathVariable Integer userId, @PathVariable Integer rewardId){
        logger.info("inside redeem points");
        rewardService.redeemPoints(userId, rewardId);
        return ResponseEntity.ok().body(new ApiResponse(" reward has been added to your account "));

    }

    @GetMapping("/get-status/{status}")
    public ResponseEntity getByExpiration(@PathVariable String status){
        logger.info("inside get by expiration status");
        return ResponseEntity.ok().body(rewardService.getByExpiration(status));
    }


    @GetMapping("/filter/{userId}")
    public ResponseEntity filterByPoints(@PathVariable Integer userId){
        logger.info("inside filter rewards by user points");
        return ResponseEntity.ok().body(rewardService.filterByPoints(userId));
    }


    @GetMapping("/myrewards/{userId}")
    public ResponseEntity myRewards(@PathVariable Integer userId){
        logger.info("inside get all user rewards");
        return ResponseEntity.ok().body(rewardService.myRewards(userId));
    }
}
