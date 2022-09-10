package com.rest.covidstatsapp.service;

import com.rest.covidstatsapp.dto.CasesDTO;
import com.rest.covidstatsapp.entity.Cases;
import com.rest.covidstatsapp.exceptions.ResourceNotFoundException;
import com.rest.covidstatsapp.mapper.CovidMapper;
import com.rest.covidstatsapp.repository.CovidRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CovidServiceTest {

    private Cases cases;
    private static final List<Cases> CASES_LIST = Collections.singletonList(Cases.builder().build());

    @Mock
    private CovidRepository covidRepository;

    @Mock
    private CovidMapper covidMapper;

    @InjectMocks
    private CovidService covidService;

    @BeforeEach
    public void setup() {
        cases = new Cases();
    }

    @Test
    void findAllInfo(){

        //Cases cases = new Cases();
        when(covidRepository.findAll()).thenReturn(Collections.singletonList(cases));

        List<Cases> actual = covidService.findAll();

        Assert.assertEquals(CASES_LIST,actual);
    }

    @Test
    void getCountryInformation(){

        CasesDTO casesDTO = new CasesDTO();
        when(covidRepository.findByCountry(any())).thenReturn(cases);
        when(covidMapper.casesMapper(cases)).thenReturn(casesDTO);

        CasesDTO actual = covidService.getCountryInfo(any());

        Assert.assertEquals(casesDTO, actual);

    }

    @Test
    void deleteEmployeeWhichDoesntExist() throws ResourceNotFoundException {

        Cases cases1 = Cases.builder()
                .id(1L)
                .totalCases(1)
                .continent(any())
                .build();

        covidRepository.deleteById(1L);
        Assert.assertThat(covidRepository.findById(1L).isEmpty());


    }
}
