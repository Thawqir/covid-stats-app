package com.rest.covidstatsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContientListDTO implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    private String continent;
    private List<CasesCountry> casesAndCountries;
}
