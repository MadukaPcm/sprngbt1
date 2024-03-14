package com.maduka.sprngbt1.Config;

import com.maduka.sprngbt1.Model.Student;
import com.maduka.sprngbt1.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student maduka = new Student("Maduka","madukapcm@gmail.com", LocalDate.of(2024, Month.APRIL,25),24);
            Student frank = new Student("Frank","frankkessi2020@gmail.com",LocalDate.of(2020,Month.FEBRUARY,20),20);

//            studentRepository.saveAll(List.of(maduka,frank));
        };
    }
}
