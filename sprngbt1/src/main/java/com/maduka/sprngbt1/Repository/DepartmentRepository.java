package com.maduka.sprngbt1.Repository;

import com.maduka.sprngbt1.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);

//    @Query(value="SELECT * FROM -----", nativeQuery = true)  Use this annotation for native queries.
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
