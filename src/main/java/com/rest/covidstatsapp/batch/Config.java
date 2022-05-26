//package com.rest.covidstatsapp.batch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.FlatFileParseException;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.transform.IncorrectTokenCountException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableBatchProcessing
//public class Config {
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public FlatFileItemReader<CasesInput> reader() {
//        return new FlatFileItemReaderBuilder<CasesInput>()
//                .name("casesItemReader")
//                .resource(new ClassPathResource("owid-covid-data_3.csv"))
//                .delimited()
//                .names(new String[]{"id", "continent", "country","date","totalcases"})
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<CasesInput>() {{
//                    setTargetType(CasesInput.class);
//                }})
//                .build();
//    }
//
//    @Bean
//    public CasesProcessor processor() {
//        return new CasesProcessor();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<CasesInput> writer(DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder<CasesInput>()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql("INSERT INTO cases_input (id, continent, country, date, total_cases) VALUES (:id, :continent, :country, :date, :totalCases)")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
//        return jobBuilderFactory.get("importUserJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step1)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1(JdbcBatchItemWriter<CasesInput> writer) {
//        return stepBuilderFactory.get("step1")
//                .<CasesInput, CasesInput> chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer)
//                .faultTolerant()
//                .skipLimit(60000)
//                .skip(IncorrectTokenCountException.class)
//                .skip(NullPointerException.class)
//                .build();
//    }
//
//}
