package com.gbusaxin.msscbrewery.web.model.v2;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

/**
 * @created : by GBu on 26. 10. 2022, streda
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@NoArgsConstructor
@Getter
@Setter
public class BeerDtoV2 {

    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;

    @Builder
    public BeerDtoV2(UUID id, String beerName, BeerStyleEnum beerStyle, Long upc) {
        this.id = id;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerDtoV2 beerDtoV2 = (BeerDtoV2) o;
        return Objects.equals(id, beerDtoV2.id) && Objects.equals(beerName, beerDtoV2.beerName) && beerStyle == beerDtoV2.beerStyle && Objects.equals(upc, beerDtoV2.upc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beerName, beerStyle, upc);
    }

    @Override
    public String toString() {
        return "BeerDtoV2{" +
                "id=" + id +
                ", beerName='" + beerName + '\'' +
                ", beerStyle=" + beerStyle +
                ", upc=" + upc +
                '}';
    }
}
