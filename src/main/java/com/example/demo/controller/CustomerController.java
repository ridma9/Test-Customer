package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.mapper.ObjectMapper;
import com.example.demo.model.CustomerModel;
import com.example.demo.service.CustomerMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerMongoService customerMongoService;
    private final ObjectMapper objectMapper;
    @PutMapping("/{id}")
    public ResponseEntity<CustomerModel> updateAccountBalance(@PathVariable String id,
                                                              @RequestBody Integer balance){
        try {
            Customer customer = customerMongoService.findCustomerById(id);
            customer.setBalance(balance);
            customerMongoService.updateCustomerDetails(customer);
            return ResponseEntity.ok(objectMapper.entityToModelMapper(customer));

        }catch (CustomerNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CustomerModel customerModel){
        customerMongoService.updateCustomerDetails(objectMapper.modelToEntityMapper(customerModel));
        return objectMapper.modelToEntityMapper(customerModel);
    }

}
