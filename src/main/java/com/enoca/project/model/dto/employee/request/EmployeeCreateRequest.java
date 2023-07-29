package com.enoca.project.model.dto.employee.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Yeni bir Employee entity nesnesi oluşturmak için kullanılan
 * request DTO nesnesidir.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateRequest {
    private String name;
    private String surname;
    private BigDecimal salary;
    private String identityNumber;
    private Integer companyId;
}
