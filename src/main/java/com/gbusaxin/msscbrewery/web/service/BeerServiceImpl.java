package com.gbusaxin.msscbrewery.web.service;

import com.gbusaxin.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @created : by GBu on 25. 10. 2022, utorok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("PIVO")
                .beerStyle("Povnnoe")
                .upc(1312312L)
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beer) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("PIVO")
                .beerStyle("Povnnoe")
                .upc(1312312L)
                .build();
    }

    @Override
    public void updateBeer(UUID id, BeerDto beerDto) {
        //TODO: implement the method
    }

    @Override
    public void deleteById(UUID beerId) {
        //TODO: implement the method
    }
}
