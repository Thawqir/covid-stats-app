package com.rest.covidstatsapp.mapper;

import com.rest.covidstatsapp.dto.CasesDTO;
import com.rest.covidstatsapp.entity.Cases;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertThat;

@ExtendWith(MockitoExtension.class)
public class CovidMapperTest {

    @Mock
    private CovidMapper mapper;

    @Test
    void convertEntityIntoDto(){
        Cases cases = Cases.builder()
                .id(1L)
                .continent("Asia")
                .country("Afghan")
                .totalCases(1000)
                .build();
        CasesDTO dto = mapper.casesMapper(cases);
        Assert.assertEquals(dto.getCountry(),cases.getCountry());
        Assert.assertEquals(dto.getTotalCases(),cases.getTotalCases());
        Assert.assertFalse(dto.getCountry().equals(cases.getCountry()));


    }
}
