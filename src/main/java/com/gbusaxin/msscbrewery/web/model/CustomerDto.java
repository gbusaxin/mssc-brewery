package com.gbusaxin.msscbrewery.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

/**
 * @created : by GBu on 26. 10. 2022, streda
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {

    private UUID id;
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @Builder
    public CustomerDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
