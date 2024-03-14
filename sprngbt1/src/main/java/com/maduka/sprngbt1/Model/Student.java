package com.maduka.sprngbt1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "student")
@Table
public class Student extends BaseEntity{
    private String name;
    private String email;
    private LocalDate dob;
//    @Transient //Making column not writable to the database
    private  int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
//    public Integer getAge(){
//        return Period.between(this.dob, LocalDate.now()).getYears();
//    }

//    public void setAge(Integer age){
//        this.age = age;
//    }
}
