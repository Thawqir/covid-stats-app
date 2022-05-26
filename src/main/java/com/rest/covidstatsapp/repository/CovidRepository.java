package com.rest.covidstatsapp.repository;

import com.rest.covidstatsapp.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CovidRepository extends JpaRepository<Cases, Long> {

    @Query(value = "SELECT id,continent,country,total_cases FROM covid.CASES cs WHERE cs.country = :country",
            nativeQuery = true)
    Cases findByCountry(String country);

    @Query(
            value = "SELECT ID,continent,country,total_cases FROM covid.cases ci WHERE ci.continent = :continent",
            nativeQuery = true)
    List<Cases> getAllCountriesForContinent(String continent);

}
