package com.rest.covidstatsapp.repository;

import com.rest.covidstatsapp.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CovidRepository extends JpaRepository<Cases, Long> {

    @Query(value = "SELECT id,continent,country,total_cases FROM covid.CASES cs WHERE cs.country = :country",
            nativeQuery = true)
    Cases findByCountry(String country);

    @Query(
            value = "SELECT ID,continent,country,total_cases FROM covid.cases ci WHERE ci.continent = :continent",
            nativeQuery = true)
    List<Cases> getAllCountriesForContinent(String continent);
    @Transactional
    @Modifying
    @Query(
            value = "update covid.cases ci SET total_cases = :total_cases WHERE ci.id = :id",
            nativeQuery = true)
    void updateTotalCasesForCountry(@Param(value = "id") long id, @Param(value = "total_cases") long total_cases);

}
