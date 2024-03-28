package com.maduka.sprngbt1.Controller.graphql;

import com.maduka.sprngbt1.Error.DepartmentNotFoundException;
import com.maduka.sprngbt1.Model.Department;
import com.maduka.sprngbt1.Service.DepartmentService;
import com.maduka.sprngbt1.ServiceImplementation.DepartmentServiceImpl;
import com.maduka.sprngbt1.payload.dtos.DepartmentDto;
import com.maduka.sprngbt1.payload.response.DepartmentResponse;
import com.maduka.sprngbt1.payload.response.Response;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class DepartmentGraphQlController {
    private final DepartmentService service;

    @Autowired
    public DepartmentGraphQlController(DepartmentServiceImpl service) {
        this.service = service;
    }

    @GraphQLQuery(name = "getAllDepartments", description = "Get all Books")
    public List<Department> getAllDepartments(){
        return service.fetchDepartmentList();
    }

    @GraphQLMutation(name = "createUpdateDepartment", description = "Create || Update department")
    public Response<Department> addDepartment(@GraphQLArgument(name = "department") DepartmentDto department){
        return service.createUpdateDepartment(department);
    }

    @GraphQLQuery(name = "getDepartmentByName", description = "Get Department by departmentName")
    public Department findByDepartmentName(@GraphQLArgument(name = "departmentName") String departmentName){
        return service.fetchDepartmentByName(departmentName);
    }

    @GraphQLQuery(name = "getDepartmentById", description = "Get Department by Id")
    public Department findByDepartmentName(@GraphQLArgument(name = "departmentId") Long departmentID) throws DepartmentNotFoundException {
        return service.getDepartmentByID(departmentID);
    }

    @GraphQLMutation(name = "deleteDepartmentById")
    public String deleteDepartmentById(@GraphQLArgument(name = "departmentById") Long departmentId){
        return service.deleteDepartmentById(departmentId);
    }
}
