package com.enoca.project.model.dto.employee.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeGetResponse {
    private Integer id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private String identityNumber;
    private String companyName;
}
