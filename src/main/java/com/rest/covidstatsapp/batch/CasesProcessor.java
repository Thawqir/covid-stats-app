//package com.rest.covidstatsapp.batch;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import org.springframework.batch.item.ItemProcessor;
//
//import java.time.LocalDate;
//
//public class CasesProcessor implements ItemProcessor<CasesInput, CasesInput>{
//
//    private static final Logger log = LoggerFactory.getLogger(CasesProcessor.class);
//
//    public CasesInput process(final CasesInput casesInput) throws Exception {
//        final long id = casesInput.getId();
//        final String continent = casesInput.getContinent();
//        final String country = casesInput.getCountry();
//        final String date = casesInput.getDate();
//        final Integer totalCases = casesInput.getTotalCases();
//
//        final CasesInput CasesOutput = new CasesInput(casesInput.getId(),
//                casesInput.getContinent(),
//                casesInput.getCountry(),
//                casesInput.getDate(),
//                casesInput.getTotalCases());
//
//        log.debug("converting" + casesInput + "into" + CasesOutput);
//
//        return CasesOutput;
//    }
//
//
//
//}
