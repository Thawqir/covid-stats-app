package com.rest.covidstatsapp.mapper;

import com.rest.covidstatsapp.dto.CasesDTO;
import com.rest.covidstatsapp.dto.ContinentDTO;
import com.rest.covidstatsapp.entity.Cases;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

@Component
@RequiredArgsConstructor
public class CovidMapper {

    public CasesDTO casesMapper(Cases cases){
        return CasesDTO.builder()
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

    //Alternate method which can also be used to convert entity into DTO;
    public CasesDTO casesModelMapper(Cases cases){
        ModelMapper mapper = new ModelMapper();
        CasesDTO dto = mapper.map(cases, CasesDTO.class);
        return dto;
    }
}
