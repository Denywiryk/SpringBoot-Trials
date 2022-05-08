package com.deny.MySpringProject.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Config {
@Bean
    CommandLineRunner commandLineRunner(StudentRepository  repository ){
        return args -> {

                      Student denis=new Student(
                            1l,
                            "wabwire",
                            "wabsdenywiry@gmail.com",
                            LocalDate.of(1999, Month.AUGUST,8)

                    );
            Student Tayebwa =new Student(

                    "wabwire",
                    "tayebwa@gmail.com",
                    LocalDate.of(1999, Month.AUGUST,8)

            );
            repository.saveAll(
                    List.of(denis,Tayebwa)
            );





        };
    }
}
