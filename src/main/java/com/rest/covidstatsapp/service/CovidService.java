package com.rest.covidstatsapp.service;

import com.rest.covidstatsapp.dto.CasesDTO;
import com.rest.covidstatsapp.dto.ContinentListDTO;
import com.rest.covidstatsapp.dto.ContinentDTO;
import com.rest.covidstatsapp.entity.Cases;
import com.rest.covidstatsapp.exceptions.ResourceNotFoundException;
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

        return mapper.casesMapper(casesRepository.findByCountry(country));
    }

    public List<ContinentDTO> getContinentInfo(String continent){
        List<Cases> entity = casesRepository.getAllCountriesForContinent(continent);

        return entity.stream()
                .map(event -> mapper.continentMapper(event))
                .collect(Collectors.toList());
    }

    public ContinentListDTO getAllCountriesForContinent(String continent){

        return mapper.continentListDTOMapper(casesRepository.getAllCountriesForContinent(continent));

    }

    public Cases saveData(Cases cases){
        return casesRepository.save(cases);
    }

    public void deleteById(long id) throws ResourceNotFoundException {
        Cases cases = casesRepository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("id not found: " + id));
            casesRepository.delete(cases);
        }

        public void updateTotalCases(long id, long total_cases) throws ResourceNotFoundException{
            casesRepository.findById(id)
                    .orElseThrow(() ->  new ResourceNotFoundException("id not found: " + id));
            casesRepository.updateTotalCasesForCountry(id,total_cases);

        }

}
