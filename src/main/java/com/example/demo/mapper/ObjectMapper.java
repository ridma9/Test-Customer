package com.example.demo.mapper;

import com.example.demo.entity.Customer;
import com.example.demo.model.CustomerModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ObjectMapper {

    private final ModelMapper mapper;

    public ObjectMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CustomerModel entityToModelMapper(Customer customer){
        return mapper.map(customer, CustomerModel.class);
    }

    public Customer modelToEntityMapper(CustomerModel customerModel){
        return mapper.map(customerModel, Customer.class);
    }
}
