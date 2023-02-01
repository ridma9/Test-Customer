/*
package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.mapper.ObjectMapper;
import com.example.demo.repository.CustomerMySqlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerMySqlService {

    private final CustomerMySqlRepository customerMySqlRepository;
    private final ObjectMapper objectMapper;

    public void updateCustomerDetails(Customer customer){
        customerMySqlRepository.save(customer);
    }

    public Customer findCustomerById(String id){
        return customerMySqlRepository.findById(id).orElseThrow(
            (()->{throw new CustomerNotFoundException("Customer Not Found");
            }));
    }

}
*/
