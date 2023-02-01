package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.mapper.ObjectMapper;
import com.example.demo.model.CustomerModel;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;

    public void updateCustomerDetails(Customer customer){
        customerRepository.save(customer);
    }

    public Customer findCustomerById(String id){
        return customerRepository.findById(Integer.valueOf(id)).orElseThrow(
            (()->{throw new CustomerNotFoundException("Customer Not Found");
            }));
    }

}
