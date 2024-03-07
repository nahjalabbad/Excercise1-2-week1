package org.example.bank_management.Controller;

import org.example.bank_management.API.ApiResponse;
import org.example.bank_management.Model.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/bank")
public class CustomersController {
    ArrayList<Customers> customers=new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody Customers customer){
        customers.add(customer);
        return new ApiResponse("Customer has been added successfully.");
    }

    @GetMapping()
    public ArrayList<Customers> getTrackers(){
        return customers;
    }


    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index, @RequestBody Customers customer){
        try {
            customers.set(index,customer);
            return new ApiResponse("Customer information Updated successfully.");
        }catch (IndexOutOfBoundsException e){
            return new ApiResponse("index out of bound");
        }

    }


    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index){
        try {
            customers.remove(index);
            return new ApiResponse("Customer has been deleted successfully.");
        }catch (IndexOutOfBoundsException e){
            return new ApiResponse("index out of bound");
        }

    }

    @PostMapping("/deposit/{id}")
    public ApiResponse deposit(@PathVariable int id, @RequestParam double amount) {
        for (Customers customer : customers) {
            if (customer.getID() == id) {
                double currentBalance = customer.getBalance();
                customer.setBalance(currentBalance + amount);
                return new ApiResponse("Old Balance is: "+currentBalance+"-------------- New Balance is " + customer.getBalance());
            }
        }
        return new ApiResponse("ID not found");
    }

    @PostMapping("/withdrawal/{id}")
    public ApiResponse withdrawal(@PathVariable int id, @RequestParam double amount) {
        for (Customers customer : customers) {
            if (customer.getID() == id) {
                double currentBalance = customer.getBalance();
                customer.setBalance(currentBalance - amount);
                return new ApiResponse("Old Balance is: "+currentBalance+"-------------- New Balance is " + customer.getBalance());
            }
        }
        return new ApiResponse("ID not found");
    }



}
