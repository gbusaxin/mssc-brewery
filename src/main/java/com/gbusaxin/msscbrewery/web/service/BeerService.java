package com.gbusaxin.msscbrewery.web.service;

import com.gbusaxin.msscbrewery.web.model.BeerDto;

import java.util.UUID;

/**
 * @created : by GBu on 25. 10. 2022, utorok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Deprecated
public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beer);

    void updateBeer(UUID id, BeerDto beerDto);

    void deleteById(UUID beerId);
}
