package com.maduka.sprngbt1.Service;

import com.maduka.sprngbt1.Error.DepartmentNotFoundException;
import com.maduka.sprngbt1.Model.Department;
import com.maduka.sprngbt1.payload.dtos.DepartmentDto;
import com.maduka.sprngbt1.payload.response.DepartmentResponse;
import com.maduka.sprngbt1.payload.response.Response;

import java.util.List;

public interface DepartmentService {
    public Response<Department> createUpdateDepartment(DepartmentDto department);

    public List<Department> fetchDepartmentList();

    public Department getDepartmentByID(Long departmentId) throws DepartmentNotFoundException;

    public String deleteDepartmentById(Long departmentId);

    public Department fetchDepartmentByName(String departmentName);
}
