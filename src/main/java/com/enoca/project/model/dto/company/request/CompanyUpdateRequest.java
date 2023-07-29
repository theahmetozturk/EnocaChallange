package com.enoca.project.model.dto.company.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyUpdateRequest {

    private String title;
    private String taxNumber;

}
