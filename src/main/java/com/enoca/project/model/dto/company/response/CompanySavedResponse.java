package com.enoca.project.model.dto.company.response;

import lombok.*;

/**
 * Yeni bir Company entity nesnesi kaydolduktan sonra kullanıcıya bu entity nesnesini
 * göstermek için kullanılan response DTO yapısıdır.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanySavedResponse {
    private Integer id;
    private String title;
    private String taxNumber;
}
