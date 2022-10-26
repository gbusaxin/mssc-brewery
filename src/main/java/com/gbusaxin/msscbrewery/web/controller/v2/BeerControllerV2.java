package com.gbusaxin.msscbrewery.web.controller.v2;

import com.gbusaxin.msscbrewery.web.model.v2.BeerDtoV2;
import com.gbusaxin.msscbrewery.web.service.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @created : by GBu on 26. 10. 2022, streda
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable(name = "beerId", required = true) UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BeerDtoV2> createNewBeer(@RequestBody(required = true) BeerDtoV2 beer) {
        BeerDtoV2 createdBeer = beerService.createNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/" + createdBeer.getId().toString());
        return new ResponseEntity<>(createdBeer ,headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeer(@PathVariable(name = "beerId") UUID id,@RequestBody(required = true) BeerDtoV2 beerDto) {
        beerService.updateBeer(id, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<Void> deleteBeer(@PathVariable UUID beerId){
        beerService.deleteById(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
