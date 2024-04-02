package org.example.largent.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.largent.API.ApiResponse;
import org.example.largent.Model.Plan;
import org.example.largent.Service.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/plan")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    Logger logger= LoggerFactory.getLogger(PlanController.class);

    @GetMapping("/get")
    public ResponseEntity getPlans(){
        logger.info("inside get plans");
        return ResponseEntity.ok().body(planService.getAllPlans());
    }

    @PostMapping("/add")
    public ResponseEntity addPlan(@RequestBody @Valid Plan plan){
        logger.info("inside add plan");
        planService.addPlan(plan);
        return ResponseEntity.ok().body(new ApiResponse("Plan has been made"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updatePlan(@PathVariable Integer id, @RequestBody @Valid Plan plan){
        logger.info("inside update plan");
        planService.updatePlan(id,plan);
        return ResponseEntity.ok().body(new ApiResponse("Plan has been updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlan(@PathVariable Integer id){
        logger.info("inside delete plan");
        planService.deletePlan(id);
        return ResponseEntity.ok().body(new ApiResponse("Plan has been deleted"));

    }

    //                    EXTRA

    @PostMapping("/add-amount/{title}/{amount}")
    public ResponseEntity addAmount(@PathVariable String title, @PathVariable Double amount){
        logger.info("inside add amount to a plan");
        planService.addAmount(title, amount);
        return ResponseEntity.ok().body(new ApiResponse(amount+" has been added to plan "+title));

    }

    @GetMapping("/get-status/{status}")
    public ResponseEntity filterByStatus(@PathVariable String status){
        logger.info("inside filter by plan status ");
        return ResponseEntity.ok().body(planService.filterByStatus(status));

    }
}
