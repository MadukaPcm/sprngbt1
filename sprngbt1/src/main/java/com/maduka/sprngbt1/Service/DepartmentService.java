package com.maduka.sprngbt1.Service;

import com.maduka.sprngbt1.Error.DepartmentNotFoundException;
import com.maduka.sprngbt1.Model.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department getDepartmentByID(Long departmentId) throws DepartmentNotFoundException;

    public String deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
