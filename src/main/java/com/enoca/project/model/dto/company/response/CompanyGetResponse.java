package com.enoca.project.model.dto.company.response;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyGetResponse {
    private Integer id;
    private String title;
    private String taxNumber;
}
