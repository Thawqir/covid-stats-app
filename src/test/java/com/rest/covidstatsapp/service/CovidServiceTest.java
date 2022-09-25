package com.rest.covidstatsapp.service;

import com.rest.covidstatsapp.dto.CasesDTO;
import com.rest.covidstatsapp.dto.ContientListDTO;
import com.rest.covidstatsapp.dto.ContinentDTO;
import com.rest.covidstatsapp.entity.Cases;
import com.rest.covidstatsapp.exceptions.ResourceNotFoundException;
import com.rest.covidstatsapp.mapper.CovidMapper;
import com.rest.covidstatsapp.repository.CovidRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CovidServiceTest {

    private Cases cases;
    private static final List<Cases> CASES_LIST = Collections.singletonList(Cases.builder().build());
    private static final ContientListDTO CONTINENT_LIST = (ContientListDTO.builder().build());
    private static final ContinentDTO CONTINENTDTO_LIST = (ContinentDTO.builder().build());

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

        assertEquals(CASES_LIST,actual);
    }

    @Test
    void getCountryInformation(){

        CasesDTO casesDTO = new CasesDTO();
        when(covidRepository.findByCountry(any())).thenReturn(cases);
        when(covidMapper.casesMapper(cases)).thenReturn(casesDTO);

        CasesDTO actual = covidService.getCountryInfo(any());

        assertEquals(casesDTO, actual);

    }

    @Test()
    void throwExceptionWhenDeletingDataWhichDoesntExist() {

        long id = 9999999L;

        assertThrows(ResourceNotFoundException.class,() -> {
            covidService.deleteById(id);
        });
    }

    @Test()
    void throwExceptionWhenUpdatingDataWhichDoesntExist() {

        long id = 9999999L;

        assertThrows(ResourceNotFoundException.class,() -> {
            covidService.updateTotalCases(id,1000);
        });
    }

    @Test
    void deleteById() throws ResourceNotFoundException {

        Cases cases1 = Cases.builder()
                .id(1L)
                .continent("Asia")
                .totalCases(1000)
                .country("Pakistan")
                .build();

        when(covidRepository.findById(1L)).thenReturn(Optional.ofNullable(cases1));
        covidService.deleteById(1L);
        verify(covidRepository).delete(cases1);
    }

    @Test
    void saveData(){
        Cases casesData = new Cases(1,"Europe","Spain",999);

        covidService.saveData(casesData);
        verify(covidRepository).save(casesData);
    }

    @Test
    void getAllCountriesFromContinent(){
        when(covidMapper.contientListDTOMapper(CASES_LIST)).thenReturn(CONTINENT_LIST);
        when(covidRepository.getAllCountriesForContinent(any())).thenReturn(CASES_LIST);

        covidService.getAllCountriesForContinent(any());

        verify(covidMapper).contientListDTOMapper(anyList());
        verify(covidRepository).getAllCountriesForContinent(any());
    }

    @Test
    void getContinentInfo(){
        when(covidMapper.continentMapper(cases)).thenReturn(CONTINENTDTO_LIST);
        when(covidRepository.getAllCountriesForContinent(any())).thenReturn(CASES_LIST);

        covidService.getContinentInfo(any());

        verify(covidMapper).continentMapper(any());
        verify(covidRepository).getAllCountriesForContinent(any());
    }

    @Test
    @Disabled
    void updateTotalCases(){


    }



}
