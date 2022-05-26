package com.rest.covidstatsapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Continent", schema = "COVID")
public class Continent {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "CONTINENT")
    private String continent;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "TOTAL_CASES")
    private int totalCases;

}
