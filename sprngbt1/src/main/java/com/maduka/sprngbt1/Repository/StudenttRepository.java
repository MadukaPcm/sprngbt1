package com.maduka.sprngbt1.Repository;

import com.maduka.sprngbt1.Model.Studentt;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudenttRepository extends JpaRepository<Studentt, Long> {

    List<Studentt> findByFirstName(String firstName);

    List<Studentt> findByFirstNameContaining(String name);

    List<Studentt> findByLastNameNotNull();

    List<Studentt> findByGuardianName(String guardianName);

    Studentt findByFirstNameAndLastName(String firstName, String lastNAme);

    // JPQL - this is defined based on the class defined, not table in database.
    @Query("select s from Studentt s where s.emailId = ?1")
    Studentt getStudenttByEmailAddress(String emailId);

    @Query("select s.firstName from Studentt s where s.emailId = ?1")
    String getStudenttByFirstNameByEmailAddress(String emailId);

    // NATIVE QUESRY always use ..... table attribute defined in database.
    @Query(
            value = "SELECT * FROM student s where s.email_address = ?1",
            nativeQuery = true
    )
    Studentt getStudenttByEmailAddressNative(String emailID);

    // NATIVE Named Param.
    @Query(
            value = "SELECT * FROM studentt s where s.email_address = :emailId",
            nativeQuery = true
    )
    Studentt getStudenttByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );

    @Modifying
    @Transactional
    @Query(
            value = "update studentt set first_name = ?1 where email_address = ?1",
            nativeQuery = true
    )
    int updateStudenttNameByEmailId(String firstName, String emailID);
}
