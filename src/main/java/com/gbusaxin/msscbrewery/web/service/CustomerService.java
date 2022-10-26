package com.gbusaxin.msscbrewery.web.service;

import com.gbusaxin.msscbrewery.web.model.CustomerDto;

import java.util.List;
import java.util.UUID;

/**
 * @created : by GBu on 26. 10. 2022, streda
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
public interface CustomerService {

    List<CustomerDto> getAllCustomers();

    CustomerDto findCustomerById(UUID id);

    void update(UUID customerId, CustomerDto customerDto);

    CustomerDto save(CustomerDto customerDto);

    void delete(UUID id);
}
