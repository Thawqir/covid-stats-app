package com.rest.covidstatsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContientListDTO {

    private String continent;
    private List<CasesCountry> casesAndCountries;
}
