package com.maduka.sprngbt1.ServiceImplementation;

import com.maduka.sprngbt1.Error.DepartmentNotFoundException;
import com.maduka.sprngbt1.Model.Department;
//import com.maduka.sprngbt1.Repository.DepartmentRepository;
import com.maduka.sprngbt1.Repository.DepartmentRepository;
import com.maduka.sprngbt1.Service.DepartmentService;
import com.maduka.sprngbt1.payload.dtos.DepartmentDto;
import com.maduka.sprngbt1.payload.response.DepartmentResponse;
import com.maduka.sprngbt1.payload.response.Response;
import com.maduka.sprngbt1.utils.ResponseCode;
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
    public Response<Department> createUpdateDepartment(DepartmentDto department) {
        try{
            Department department1 = new Department();
            if(department != null){
                if(department.getDepartmentUuid() != null && !department.getDepartmentUuid().isBlank()){
                    Optional<Department> departmentOptional = departmentRepository.findFirstByUuid(department.getDepartmentUuid());
                    if (departmentOptional.isPresent()){
                        department1 = departmentOptional.get();
                    }else {
                        return new Response<>(true,ResponseCode.FAIL,ResponseCode.MSG_INVALID_UNIQUE_ID);
                    }
                }

                if(department.getDepartmentName() == null || department.getDepartmentName().isBlank())
                    return new Response<>(true, ResponseCode.NULL_ARGUMENT,"Department name is required");
                if (department.getDepartmentAddress() == null || department.getDepartmentAddress().isBlank())
                    return new Response<>(true,ResponseCode.NULL_ARGUMENT,"Department address is required");
                if (department.getDepartmentCode() == null || department.getDepartmentCode().isBlank())
                    return new Response<>(true,ResponseCode.NULL_ARGUMENT,"Department code is required");


                department1.setDepartmentName(department.getDepartmentName());
                department1.setDepartmentAddress(department.getDepartmentAddress());
                department1.setDepartmentCode(department.getDepartmentCode());

                Department department2 = departmentRepository.save(department1);
                return new Response<>(false, ResponseCode.SUCCESS,ResponseCode.MSG_OPERATION_SUCCESSFUL,department2,null);
            }

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new Response<>(true,ResponseCode.FAIL,ResponseCode.MSG_OPERATION_UNSUCCESSFUL);
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
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
