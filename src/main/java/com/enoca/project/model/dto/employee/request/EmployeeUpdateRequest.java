package com.enoca.project.model.dto.employee.request;

import com.enoca.project.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateRequest {
    private Integer id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private String identityNumber;
    private Integer companyId;

    public EmployeeUpdateRequest(Employee employee){
        id = employee.getId();
        name = employee.getName();
        surname = employee.getSurname();
        salary = employee.getSalary();
        identityNumber = employee.getIdentityNumber();
        companyId = employee.getCompany().getId();
    }
    public EmployeeUpdateRequest(Employee employee, Integer companyId){
        id = employee.getId();
        name = employee.getName();
        surname = employee.getSurname();
        salary = employee.getSalary();
        identityNumber = employee.getIdentityNumber();
        this.companyId = companyId;
    }

}
