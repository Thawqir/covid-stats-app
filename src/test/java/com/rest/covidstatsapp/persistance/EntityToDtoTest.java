//package com.rest.covidstatsapp.persistance;
//
//import com.rest.covidstatsapp.model.Continent;
//import com.rest.covidstatsapp.model.ContinentDTO;
//import com.rest.covidstatsapp.service.ContinentService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class EntityToDtoTest {
//
//    private ModelMapper modelMapper = new ModelMapper();
//
////    @Test
////    public void testToDto() {
////        Continent entity = new Continent("Europe", "Jon", 1000);
////
////        ContinentService mapper = new ContinentService();
////        ContinentDTO dto = mapper.convertEntityToDtoOld(entity);
////
////        Assert.assertEquals(dto.getContinent(), entity.getContinent());
////    }
//
//    @Test
//    public void testModelMapperToDto() {
//        Continent entity = new Continent("Europe", "Jon", 1000);
//
//        ContinentDTO dto = modelMapper.map(entity, ContinentDTO.class);
//
//        Assert.assertEquals(dto.getContinent(), entity.getContinent());
//    }
//}
