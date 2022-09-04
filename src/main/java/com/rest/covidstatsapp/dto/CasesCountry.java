package com.rest.covidstatsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CasesCountry implements Serializable {

    private static final long serialVersionUID = 7156526077883092384L;

    private int totalCases;
    private String country;
}
