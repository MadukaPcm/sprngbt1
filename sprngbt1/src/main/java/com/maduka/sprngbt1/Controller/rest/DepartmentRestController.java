package com.maduka.sprngbt1.Controller.rest;

import com.maduka.sprngbt1.Error.DepartmentNotFoundException;
import com.maduka.sprngbt1.Model.Department;
import com.maduka.sprngbt1.Service.DepartmentService;
import com.maduka.sprngbt1.payload.dtos.DepartmentDto;
import com.maduka.sprngbt1.payload.response.DepartmentResponse;
import com.maduka.sprngbt1.payload.response.Response;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentRestController {
    private final DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentRestController.class);

    @Autowired
    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Response<Department> createUpdateDepartment(@Valid @RequestBody DepartmentDto department){
        LOGGER.info("Inside the department !!");
        return departmentService.createUpdateDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentByID(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.deleteDepartmentById(departmentId);
    }

    @GetMapping("departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
