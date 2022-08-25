package com.rest.covidstatsapp.mapper;

import com.rest.covidstatsapp.dto.CasesCountry;
import com.rest.covidstatsapp.dto.CasesDTO;
import com.rest.covidstatsapp.dto.ContientListDTO;
import com.rest.covidstatsapp.dto.ContinentDTO;
import com.rest.covidstatsapp.entity.Cases;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CovidMapper {

    public CasesDTO casesMapper(Cases cases){
        return CasesDTO.builder()
                .id(cases.getId())
                .country(cases.getCountry())
                .totalCases(cases.getTotalCases())
                .build();
    }

    public ContinentDTO continentMapper(Cases cases){
        return ContinentDTO.builder()
                .continent(cases.getContinent())
                .country(cases.getCountry())
                .totalCases(cases.getTotalCases())
                .build();
    }

    public ContientListDTO contientListDTOMapper(List<Cases> cases){

        return ContientListDTO.builder()
                .continent(cases.get(0).getContinent())
                .casesAndCountries(cases.stream()
                        .map(cases1 ->
                                CasesCountry.builder()
                                        .country(cases1.getCountry())
                                        .totalCases(cases1.getTotalCases())
                        .build())
                        .collect(Collectors.toList())
                )
                .build();
    }



    //Alternate method which can also be used to convert entity into DTO;
    public CasesDTO casesModelMapper(Cases cases){
        ModelMapper mapper = new ModelMapper();
        CasesDTO dto = mapper.map(cases, CasesDTO.class);
        return dto;
    }
}
