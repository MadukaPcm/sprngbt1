package com.maduka.sprngbt1.Controller.rest;

import com.maduka.sprngbt1.Model.Student;
import com.maduka.sprngbt1.Model.Studentt;
import com.maduka.sprngbt1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired  // Dependancy injection.
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Studentt> getStudent(){
        return studentService.getStudents();
    }

//    @PostMapping
//    public void registerNewStudent(@RequestBody Studentt student){
//         studentService.addNewStudent(student);
//    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
//
//    @PutMapping(path = "{studentId}")
//    public void updateStudent(
//            @PathVariable("studentId") Long studentId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String email
//    ){
//        studentService.updateStudent(studentId, name, email);
//    }

}




//
//import org.springframework.data.jpa.domain.Specification;
//import javax.persistence.criteria.*;
//        import java.time.LocalDateTime;
//
//public class MeetingSpecification {
//
//    public static Specification<Meeting> getMeetingsByFilters(String title, String location, LocalDateTime startDate, UserAccount userAccount) {
//        return (root, query, criteriaBuilder) -> {
//            Predicate predicate = criteriaBuilder.conjunction();
//
//            if (title != null && !title.isEmpty()) {
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("title"), title));
//            }
//
//            if (location != null && !location.isEmpty()) {
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("location"), location));
//            }
//
//            if (startDate != null) {
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("startDate"), startDate));
//            }
//
//            if (userAccount != null) {
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("userAccount"), userAccount));
//            }
//
//            // Additional dynamic filters can be added here
//
//            return predicate;
//        };
//    }
//}



//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface MeetingRepository extends JpaRepository<Meeting, Long>, JpaSpecificationExecutor<Meeting> {
//}


//
//import java.time.LocalDateTime;
//import java.util.List;
//
//public interface MeetingService {
//    List<Meeting> getMeetingsByFilters(String title, String location, LocalDateTime startDate, UserAccount userAccount);
//}

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class MeetingServiceImpl implements MeetingService {
//
//    private final MeetingRepository meetingRepository;
//
//    @Autowired
//    public MeetingServiceImpl(MeetingRepository meetingRepository) {
//        this.meetingRepository = meetingRepository;
//    }
//
//    @Override
//    public List<Meeting> getMeetingsByFilters(String title, String location, LocalDateTime startDate, UserAccount userAccount) {
//        return meetingRepository.findAll(MeetingSpecification.getMeetingsByFilters(title, location, startDate, userAccount));
//    }
//}

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//public class MeetingController {
//
//    private final MeetingService meetingService;
//
//    @Autowired
//    public MeetingController(MeetingService meetingService) {
//        this.meetingService = meetingService;
//    }
//
//    @GetMapping("/meetings")
//    public List<Meeting> getMeetings(@RequestParam(required = false) String title,
//                                     @RequestParam(required = false) String location,
//                                     @RequestParam(required = false) LocalDateTime startDate,
//                                     @RequestParam(required = false) Long userAccountId) {
//        UserAccount userAccount = null;
//        if (userAccountId != null) {
//            // Fetch the UserAccount by ID or other means
//            userAccount = ...;
//        }
//        return meetingService.getMeetingsByFilters(title, location, startDate, userAccount);
//    }
//}

