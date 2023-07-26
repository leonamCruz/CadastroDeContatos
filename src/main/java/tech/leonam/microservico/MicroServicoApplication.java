package tech.leonam.microservico;

import jakarta.servlet.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.leonam.microservico.config.IpFilter;

@SpringBootApplication
public class MicroServicoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServicoApplication.class, args);
    }
    @Bean
    public Filter ipFilter(){
        return new IpFilter();
    }
}
