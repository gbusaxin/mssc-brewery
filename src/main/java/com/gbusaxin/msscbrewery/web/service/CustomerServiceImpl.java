package com.gbusaxin.msscbrewery.web.service;

import com.gbusaxin.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @created : by GBu on 26. 10. 2022, streda
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<CustomerDto> getAllCustomers() {
        return null;
    }

    @Override
    public CustomerDto findCustomerById(UUID id) {
        return null;
    }

    @Override
    public void update(UUID customerId, CustomerDto customerDto) {
        //TODO: implement the method
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        //TODO: implement the method
    }
}
