package fr.univ_poitiers.croussards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class CroussardsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CroussardsApplication.class, args);
    }

}
