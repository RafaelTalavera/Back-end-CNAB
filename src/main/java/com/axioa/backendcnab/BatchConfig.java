package com.axioa.backendcnab;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;



@Configuration
public class BatchConfig {

    private PlatformTransactionManager transactionManager;
    private JobRepository jobRepository;

    public BatchConfig(PlatformTransactionManager platformTransactionManager, JobRepository jobRepository) {
        this.transactionManager = platformTransactionManager;
        this.jobRepository = jobRepository;
    }

    @Bean
    Job job(Step step) {

        return new JobBuilder("job", jobRepository)
        .start(step).incrementer(new RunIdIncrementer()).build();
    }

    @Bean
    Step step(ItemReader<TransactionCNAB> reader, ItemProcessor<TransactionCNAB, Transation> processor, ItemWriter<Transation> writer){

        return  new StepBuilder("step", jobRepository)
                .<TransactionCNAB, Transation >chunk(1000,transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}