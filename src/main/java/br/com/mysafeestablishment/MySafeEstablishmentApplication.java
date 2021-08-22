package br.com.mysafeestablishment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MySafeEstablishmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySafeEstablishmentApplication.class, args);
    }

}
