package com.enoca.project.mapper;

import com.enoca.project.model.dto.employee.request.EmployeeCreateRequest;
import com.enoca.project.model.dto.employee.response.EmployeeGetResponse;
import com.enoca.project.model.dto.employee.response.EmployeeSavedResponse;
import com.enoca.project.model.entity.Company;
import com.enoca.project.model.entity.Employee;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Employee entity nesneleri ile DTO nesneleri arasında mapleme yapan
 * mapper sınıftır.
 */
public class EmployeeMapper {

    public static Employee mapForSaving(
            EmployeeCreateRequest request
    ){
        return Employee.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .salary(request.getSalary())
                .identityNumber(request.getIdentityNumber())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static EmployeeSavedResponse toSavedResponse(
            Employee employee
    ) {
        return EmployeeSavedResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .salary(employee.getSalary())
                .identityNumber(employee.getIdentityNumber())
                .companyTitle(
                        employee.getCompany().getTitle()
                )
                .build();
    }
    public static EmployeeGetResponse toGetResponse(Employee employee){
        return EmployeeGetResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .salary(employee.getSalary())
                .identityNumber(employee.getIdentityNumber())
                .companyName(
                        employee.getCompany().getTitle()
                )
                .build();
    }

    public static List<EmployeeGetResponse> toGetResponse(List<Employee> employees){
        if (employees == null)
            return null;
        List<EmployeeGetResponse> responses = new ArrayList<>();

        for (Employee employee: employees){
            responses.add(toGetResponse(employee));
        }
        return responses;
    }
}
