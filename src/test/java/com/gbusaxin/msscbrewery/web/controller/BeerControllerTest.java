package com.gbusaxin.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbusaxin.msscbrewery.web.model.BeerDto;
import com.gbusaxin.msscbrewery.web.service.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;

import java.time.OffsetDateTime;
import java.util.UUID;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @created : by GBu on 3. 11. 2022, štvrtok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    @BeforeEach
    void setUp() {
        validBeer = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Baltika")
                .beerStyle("STOUT")
                .upc(1231421123L)
                .build();
    }

    @Test
    void getBeer() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        ConstrainedFields fields = new ConstrainedFields(BeerDto.class);

        mockMvc.perform(get("/api/v1/beer/{beerId}", validBeer.getId().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(validBeer.getId().toString()))) Does not work
//                .andExpect(jsonPath("$.beerName", is(validBeer.getBeerName())))
                .andDo(document("v1/beer-get",
                        pathParameters(
                                parameterWithName("beerId").description("UUID of desired beer to get.")
                        ),
                        responseFields(
                                fields.withPath("id").description("Id of Beer").type(UUID.class),
                                fields.withPath("createdDate").description("Date created").type(OffsetDateTime.class),
                                fields.withPath("lastUpdatedDate").description("Date updated").type(OffsetDateTime.class),
                                fields.withPath("beerName").description("Beer Name"),
                                fields.withPath("beerStyle").description("Beer Style"),
                                fields.withPath("upc").description("UPC of Beer")
                        )
                ));
    }

    @Test
    void createNewBeer() throws Exception {
        //given
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        BeerDto savedBeer = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveNewBeer(any())).willReturn(savedBeer);

        ConstrainedFields fields = new ConstrainedFields(BeerDto.class);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isCreated())
                .andDo(document("v1/beer-new",
                        requestFields(
                                fields.withPath("id").description("Id of Beer").ignored(),
                                fields.withPath("createdDate").description("Date created").ignored(),
                                fields.withPath("lastUpdatedDate").description("Date updated").ignored(),
                                fields.withPath("beerName").description("Name of Beer"),
                                fields.withPath("beerStyle").description("Style of Beer"),
                                fields.withPath("upc").description("UPC of Beer")
                        )
                ));
    }

    @Test
    void updateBeer() {
    }

    @Test
    void deleteBeer() {
    }

    private static class ConstrainedFields {
        private final ConstraintDescriptions constraintDescriptions;


        private ConstrainedFields(Class<?> input) {
            this.constraintDescriptions = new ConstraintDescriptions(input);
        }

        private FieldDescriptor withPath(String path){
            return fieldWithPath(path).attributes(key("constraints").value(StringUtils.collectionToDelimitedString(
                    this.constraintDescriptions.descriptionsForProperty(path), ". "
            )));
        }
    }
}