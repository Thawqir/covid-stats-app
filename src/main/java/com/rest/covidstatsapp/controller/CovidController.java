package com.rest.covidstatsapp.controller;

import com.rest.covidstatsapp.dto.CasesDTO;
import com.rest.covidstatsapp.dto.ContinentDTO;
import com.rest.covidstatsapp.entity.Cases;
import com.rest.covidstatsapp.service.CovidService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/covid")
@RequiredArgsConstructor
public class CovidController {

    private final CovidService covidService;


    @GetMapping("/country")
    public List<Cases> getAllCountry(){
        return covidService.findAll();
    }

    @GetMapping("/country/{country}")
    public CasesDTO getDataByCountry(@PathVariable("country") String country){
        return covidService.getCountryInfo(country);
    }

    @GetMapping("/continent/{continent}")
    public List<ContinentDTO> getDataByContinent(@PathVariable("continent") String continent){
        return covidService.getContinentInfo(continent);
    }

    @PostMapping("/save")
    public Cases saveData(@RequestBody Cases cases){
        return covidService.saveData(cases);
    }

}
