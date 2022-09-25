package com.rest.covidstatsapp.repository;

import com.rest.covidstatsapp.entity.Cases;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.*;

@DataJpaTest
public class CovidRepositoryIntegrationTest {

    @Autowired
    CovidRepository covidRepository;

    @Test
    void findByCountry(){

        Cases cases = covidRepository.findByCountry("England");
        assertTrue(cases.getCountry(), equals("England"));

    }
}
