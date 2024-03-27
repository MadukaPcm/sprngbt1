package com.maduka.sprngbt1.ServiceImplementation;

import com.maduka.sprngbt1.Error.DepartmentNotFoundException;
import com.maduka.sprngbt1.Model.Department;
//import com.maduka.sprngbt1.Repository.DepartmentRepository;
import com.maduka.sprngbt1.Repository.DepartmentRepository;
import com.maduka.sprngbt1.Service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    public final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByID(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(department.isEmpty()){
            throw new DepartmentNotFoundException("Department Not Available !!");
        }
        return department.get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);

        if(departmentOptional.isPresent()){
            departmentRepository.deleteById(departmentId);
            return "Department with id "+departmentId+" deleted !!";
        }
        else {
            throw new EntityNotFoundException("Department with Id "+ departmentId+ " Not found");
        }

    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depdb = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depdb.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depdb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depdb.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depdb);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
