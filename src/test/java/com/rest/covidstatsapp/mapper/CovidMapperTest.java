package com.rest.covidstatsapp.mapper;

import com.rest.covidstatsapp.dto.CasesDTO;
import com.rest.covidstatsapp.dto.ContinentListDTO;
import com.rest.covidstatsapp.dto.ContinentDTO;
import com.rest.covidstatsapp.entity.Cases;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CovidMapperTest {

    @Test
    void convertCasesIntoCasesDTO(){

        CovidMapper mapper = new CovidMapper();
        Cases cases = Cases.builder()
                .id(1L)
                .continent("Asia")
                .country("Afghan")
                .totalCases(1000)
                .build();

        CasesDTO casesDTO = mapper.casesMapper(cases);

        assertTrue(cases.getCountry().equals(casesDTO.getCountry()));
        assertTrue(cases.getTotalCases().equals(casesDTO.getTotalCases()));

    }

    @Test
    void convertCasesIntoContinentDTO(){

        CovidMapper mapper = new CovidMapper();
        Cases cases = Cases.builder()
                .id(1L)
                .continent("Asia")
                .country("Afghan")
                .totalCases(1000)
                .build();

        ContinentDTO continentDTO = mapper.continentMapper(cases);

        assertTrue(cases.getCountry().equals(continentDTO.getCountry()));
        assertTrue(cases.getTotalCases().equals(continentDTO.getTotalCases()));
        assertTrue(cases.getContinent().equals(continentDTO.getContinent()));

    }

    @Test
    void convertListOfCasesIntoContinentListDTO(){

        CovidMapper mapper = new CovidMapper();
        List<Cases> cases = Collections.singletonList(Cases.builder()
                .id(1L)
                .continent("Asia")
                .country("Afghan")
                .totalCases(1000)
                .build());

        ContinentListDTO contientDTO = mapper.continentListDTOMapper(cases);

        assertTrue(cases.get(0).getContinent().equals(contientDTO.getContinent()));
        assertTrue(cases.get(0).getCountry().equals(contientDTO.getCasesAndCountries().get(0).getCountry()));
        assertTrue(cases.get(0).getTotalCases().equals(contientDTO.getCasesAndCountries().get(0).getTotalCases()));

    }
}
