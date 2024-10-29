package com.maduka.sprngbt1.Service;

import com.maduka.sprngbt1.Model.Student;
import com.maduka.sprngbt1.Model.Studentt;
import com.maduka.sprngbt1.Repository.StudenttRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;  
import java.util.Objects;
import java.util.Optional;

@Service   // A class to be initiantiated.. for being injected.
public class StudentService {

    private final StudenttRepository studentRepository;

    @Autowired
    public StudentService(StudenttRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Studentt> getStudents(){
        return studentRepository.findAll();
    }

//    public void addNewStudent(Studentt student) {
//        Optional<Studentt> studentOptional = studentRepository.find(student.getEmail());
//        if(studentOptional.isPresent()){
//            throw new IllegalStateException("Email taken");
//        }
//        studentRepository.save(student);
//    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id "+studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);

    }

//    @Transactional
//    public void updateStudent(Long studentId, String name, String email) {
//
//        Studentt student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("Student with id "+ studentId + " does not exist"));
//
//        if(name != null && name.isEmpty() && !Objects.equals(student.getFirstName(), name)){
//            student.setFirstName(name);
//        }
//
//        if(email != null && email.isEmpty() && !Objects.equals(student.getEmailId(), email)){
//            Optional<Studentt> studentOptional = studentRepository.findByEmailId(email);
//
//            if(studentOptional.isPresent()){
//                throw new IllegalStateException("Email is already taken!!!");
//            }
//            student.setEmail(email);
//        }
//    }
}
