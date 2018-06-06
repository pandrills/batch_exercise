package homeoffice.Batch_Exercise;

import homeoffice.model.VehicleDetails;

import homeoffice.processor.VehicleDetailsProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * Created by musti on 05/06/2018.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Value(value= "in/car_*.csv")
    private Resource[] resources;



    @Bean
    public FlatFileItemReader<VehicleDetails> reader(){
        FlatFileItemReader<VehicleDetails> reader = new FlatFileItemReader<VehicleDetails>();
        reader.setLineMapper(new DefaultLineMapper<VehicleDetails>(){{
            setLineTokenizer(new DelimitedLineTokenizer(){{
                setNames(new String[]{"id","vehicleMake","colour"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<VehicleDetails>(){{
                setTargetType(VehicleDetails.class);
            }});
        }});
        return reader;
    }

    @Bean
    public MultiResourceItemReader<VehicleDetails> multiResourceItemReader(){
        MultiResourceItemReader<VehicleDetails> multi = new MultiResourceItemReader<VehicleDetails>();
        multi.setResources(resources);
        multi.setDelegate(reader());
        return multi;
    }

    @Bean
    public FlatFileItemWriter<VehicleDetails> writer(){
        FlatFileItemWriter<VehicleDetails> writer=new FlatFileItemWriter<VehicleDetails>();
        writer.setResource(new ClassPathResource("out/car_details.csv"));
        writer.setAppendAllowed(true);
        writer.setLineAggregator(new DelimitedLineAggregator<VehicleDetails>(){{
            setDelimiter(",");
            setFieldExtractor(new BeanWrapperFieldExtractor<VehicleDetails>(){{
                setNames(new String[]{"id","vehicleMake","colour"});
            }});
        }});

        return writer;

    }


    @Bean
    public VehicleDetailsProcessor processor() {
        return new VehicleDetailsProcessor();
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1")
                .<VehicleDetails,VehicleDetails> chunk(10)
                .reader(multiResourceItemReader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job mainJob(){
        return jobBuilderFactory.get("mainjob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();

    }
}
