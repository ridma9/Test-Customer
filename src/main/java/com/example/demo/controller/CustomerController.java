package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.CustomerModel;
import com.example.demo.service.CustomerMongoService;
//import com.example.demo.service.CustomerMySqlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CustomerController {
//    private final CustomerMySqlService customerMySqlService;
    private final CustomerMongoService customerMongoService;
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAccountBalance(@PathVariable String id,
                                                              @RequestBody CustomerModel customerModel){
/*
        try {
            Customer customer = customerMySqlService.findCustomerById(id);
            customer.setBalance(customerModel.getBalance());
            customerMySqlService.updateCustomerDetails(customer);
            return ResponseEntity.ok("Account balance Updated");
        }catch (CustomerNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
*/
        try {
            Customer customer = customerMongoService.findCustomerById(id);
            customer.setBalance(customerModel.getBalance());
            customerMongoService.updateCustomerDetails(customer);
            return ResponseEntity.ok("Account balance Updated");
        }catch (CustomerNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

}
