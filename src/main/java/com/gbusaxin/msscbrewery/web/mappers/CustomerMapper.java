package com.gbusaxin.msscbrewery.web.mappers;

import com.gbusaxin.msscbrewery.domain.Customer;
import com.gbusaxin.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

/**
 * @created : by GBu on 27. 10. 2022, štvrtok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);

}
