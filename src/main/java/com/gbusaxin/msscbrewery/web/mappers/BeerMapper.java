package com.gbusaxin.msscbrewery.web.mappers;

import com.gbusaxin.msscbrewery.domain.Beer;
import com.gbusaxin.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * @created : by GBu on 27. 10. 2022, štvrtok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Mapper
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

}
