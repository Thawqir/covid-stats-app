package com.rest.covidstatsapp.controller;

import com.rest.covidstatsapp.dto.CasesDTO;
import com.rest.covidstatsapp.dto.ContinentDTO;
import com.rest.covidstatsapp.entity.Cases;
import com.rest.covidstatsapp.exceptions.ResourceNotFoundException;
import com.rest.covidstatsapp.service.CovidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CasesDTO> getDataByCountry(@PathVariable("country") String country){
        CasesDTO response =  covidService.getCountryInfo(country);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Description","Get country by name");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
    }

    @GetMapping("/continent/{continent}")
    public List<ContinentDTO> getDataByContinent(@PathVariable("continent") String continent){
        return covidService.getContinentInfo(continent);
    }

    @PostMapping("/save")
    public Cases saveData(@RequestBody Cases cases){
        return covidService.saveData(cases);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        covidService.deleteEmployee(id);
    }

    @PatchMapping("/update/{id}/{totalCases}")
    public void updateCaseNumber(@PathVariable(value = "id") long id,
                                 @PathVariable (value = "totalCases")long total_cases) throws ResourceNotFoundException {
        covidService.updateTotalCases(id, total_cases);
    }

}
