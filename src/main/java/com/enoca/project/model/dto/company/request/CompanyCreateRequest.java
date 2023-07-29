package com.enoca.project.model.dto.company.request;

import lombok.*;

/**
 * Yeni bir Company oluşturmak için kullanılan request DTO nesnesidir.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyCreateRequest {
    private String title;
    private String taxNumber;
}
