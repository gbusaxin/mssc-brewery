package com.gbusaxin.msscbrewery.web.service.v2;

import com.gbusaxin.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

/**
 * @created : by GBu on 26. 10. 2022, streda
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
public interface BeerServiceV2 {

    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 createNewBeer(BeerDtoV2 beer);

    void updateBeer(UUID id, BeerDtoV2 beerDto);

    void deleteById(UUID beerId);

}
