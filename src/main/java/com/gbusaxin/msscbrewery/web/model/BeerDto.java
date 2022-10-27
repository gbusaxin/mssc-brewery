package com.gbusaxin.msscbrewery.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.Objects;
import java.util.UUID;

/**
 * @created : by GBu on 25. 10. 2022, utorok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Getter
@Setter
@NoArgsConstructor
public class BeerDto {

    @Null
    private UUID id;
    @NotBlank
    private String beerName;
    @NotBlank
    private String beerStyle;
    @Positive
    private Long upc;

    @Builder
    public BeerDto(UUID id, String beerName, String beerStyle, Long upc) {
        this.id = id;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerDto beerDto = (BeerDto) o;
        return Objects.equals(id, beerDto.id) && Objects.equals(beerName, beerDto.beerName) && Objects.equals(beerStyle, beerDto.beerStyle) && Objects.equals(upc, beerDto.upc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beerName, beerStyle, upc);
    }

    @Override
    public String toString() {
        return "BeerDto{" +
                "id=" + id +
                ", beerName='" + beerName + '\'' +
                ", beerStyle='" + beerStyle + '\'' +
                ", upc=" + upc +
                '}';
    }
}
