package com.enoca.project.model.dto.employee.response;

import lombok.*;

import java.math.BigDecimal;

/**
 * Bir Employee entity nesnesi kaydedildiğinde
 * kaydedilen Employee entity nesnesini göstermek için kullanılan
 * response DTO nesnesidir.
 *
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSavedResponse {
    private Integer id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private String identityNumber;
    private String companyTitle;
}
