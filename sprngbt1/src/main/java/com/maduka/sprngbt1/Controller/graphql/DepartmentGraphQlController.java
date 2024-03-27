package com.maduka.sprngbt1.Controller.graphql;

import com.maduka.sprngbt1.Model.Department;
import com.maduka.sprngbt1.Service.DepartmentService;
import com.maduka.sprngbt1.ServiceImplementation.DepartmentServiceImpl;
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
}
