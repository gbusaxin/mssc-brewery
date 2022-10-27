package com.gbusaxin.msscbrewery.web.controller;

import com.gbusaxin.msscbrewery.web.model.BeerDto;
import com.gbusaxin.msscbrewery.web.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @created : by GBu on 25. 10. 2022, utorok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Deprecated
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@NotNull @PathVariable(name = "beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BeerDto> createNewBeer(@Validated @RequestBody BeerDto beer) {
        BeerDto createdBeer = beerService.createNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/" + createdBeer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeer(@NotNull @PathVariable(name = "beerId") UUID id, @Validated @RequestBody BeerDto beerDto) {
        beerService.updateBeer(id, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<Void> deleteBeer(@NotNull @PathVariable UUID beerId) {
        beerService.deleteById(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
