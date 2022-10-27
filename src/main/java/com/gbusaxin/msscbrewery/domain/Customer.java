package com.gbusaxin.msscbrewery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @created : by GBu on 27. 10. 2022, štvrtok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private UUID id;
    private String name;

}
