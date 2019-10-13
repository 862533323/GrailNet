package cn.rfh.grailnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class GrailNetApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrailNetApplication.class, args);
    }

}
