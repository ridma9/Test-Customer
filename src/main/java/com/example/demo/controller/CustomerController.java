package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.CustomerModel;
import com.example.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAccountBalance(@PathVariable String id,
                                                              @RequestBody CustomerModel customerModel){
        try {
            Customer customer = customerService.findCustomerById(id);
            customer.setBalance(customerModel.getBalance());
            customerService.updateCustomerDetails(customer);
            return ResponseEntity.ok("Account balance Updated");
        }catch (CustomerNotFoundException ex){
            return ResponseEntity.notFound().build();
        }

    }



}
