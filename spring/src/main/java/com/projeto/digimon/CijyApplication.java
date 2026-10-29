package com.projeto.digimon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages ="com.projeto.digimon")
@SpringBootApplication
public class CijyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CijyApplication.class, args);
    }

}