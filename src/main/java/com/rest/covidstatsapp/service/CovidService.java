package com.rest.covidstatsapp.service;

import com.rest.covidstatsapp.dto.CasesDTO;
import com.rest.covidstatsapp.dto.ContinentDTO;
import com.rest.covidstatsapp.entity.Cases;
import com.rest.covidstatsapp.mapper.CovidMapper;
import com.rest.covidstatsapp.repository.CovidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CovidService {


    private final CovidRepository casesRepository;
    private final CovidMapper mapper;

    public List<Cases> findAll(){
        return casesRepository.findAll();
    }

    public CasesDTO getCountryInfo(String country){
        Cases entity = casesRepository.findByCountry(country);
        CasesDTO dto = mapper.casesMapper(entity);
        return dto;
    }

    public List<ContinentDTO> getContinentInfo(String continent){
        List<Cases> entity = casesRepository.getAllCountriesForContinent(continent);

        return entity.stream()
                .map(event -> mapper.continentMapper(event))
                .collect(Collectors.toList());

    }

    public Cases saveData(Cases cases){
//        Cases newData = new Cases();
//        newData.setId(cases.getId());
//        newData.setCountry(cases.getCountry());
//        newData.setContinent(cases.getContinent());
//        newData.setTotalCases(cases.getTotalCases());
        return casesRepository.save(cases);
    }
}
