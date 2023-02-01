package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.repository.CustomerMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerMongoService {
    private final CustomerMongoRepository customerMongoRepository;
    public void updateCustomerDetails(Customer customer){
        customerMongoRepository.save(customer);
    }

    public Customer findCustomerById(String id){
        return customerMongoRepository.findById(id).orElseThrow(
                (()->{throw new CustomerNotFoundException("Customer Not Found");
                }));
    }

}
