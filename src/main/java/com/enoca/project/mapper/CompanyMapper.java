package com.enoca.project.mapper;

import com.enoca.project.model.dto.company.request.CompanyCreateRequest;
import com.enoca.project.model.dto.company.response.CompanyGetResponse;
import com.enoca.project.model.dto.company.response.CompanySavedResponse;
import com.enoca.project.model.entity.Company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Company entity nesneleri ile DTO nesneleri arasında mapleme işlemlerini gerçekleştiren
 * mapper sınıftır.
 */
public class CompanyMapper {

    public static Company mapForSaving(
            CompanyCreateRequest request
    ){
        return Company.builder()
                .title(request.getTitle())
                .taxNumber(request.getTaxNumber())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static CompanySavedResponse toSavedResponse(
            Company company
    ){
        return CompanySavedResponse.builder()
                .id(company.getId())
                .title(company.getTitle())
                .taxNumber(company.getTaxNumber())
                .build();
    }

    public static CompanyGetResponse toGetResponse(
            Company company
    ) {
        return CompanyGetResponse.builder()
                .id(company.getId())
                .title(company.getTitle())
                .taxNumber(company.getTaxNumber())
                .build();
    }

    public static List<CompanyGetResponse> toGetResponse(
            List<Company> companies
    ){
        /*
        return companies.stream()
                .map(CompanyMapper::toGetResponse)
                .toList();
         */

        if (companies == null)
            return null;

        List<CompanyGetResponse> responses = new ArrayList<>();


        for (Company company :
                companies) {
            responses.add(toGetResponse(company));
        }

        return responses;
    }

}
