package com.enoca.project.controller;

import com.enoca.project.mapper.CompanyMapper;
import com.enoca.project.model.dto.company.request.CompanyCreateRequest;
import com.enoca.project.model.dto.company.request.CompanyUpdateRequest;
import com.enoca.project.model.dto.company.response.CompanyGetResponse;
import com.enoca.project.model.dto.company.response.CompanySavedResponse;
import com.enoca.project.model.entity.Company;
import com.enoca.project.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Company Entity nesnelerinin yönetiminden sorumlu REST Controller sınıfıdır.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    // TODO : Yeni bir Company oluşturan api yazılacak.         [DONE]
    // TODO : ID değerini URL üzerinden belirttiğim Company nesnesini geriye döndüren api yazılacak.       [DONE]
    // TODO : Tüm company nesnelerini geriye döndüren api yazılacak. [DONE]
    // TODO : ID değeri url üzerinden belirtilen Company nesnesini silen api yazılacak.
    // TODO : ID değeri url üzerinden belirtilen Company nesnesini güncelleyen api yazılacak.

    @PostMapping
    public ResponseEntity<CompanySavedResponse> createCompany(
            @RequestBody CompanyCreateRequest request
    ) {
        final Company company = companyService.createCompany(request);
        final CompanySavedResponse response = CompanyMapper.toSavedResponse(company);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<?> getCompanyById(
            @PathVariable("companyId") Integer companyId
    ) {

        Company company = null;
        try {
            company = companyService.getCompanyById(companyId);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

        final CompanyGetResponse response = CompanyMapper.toGetResponse(company);


        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<?> getAllCompanies(
    ) {
        final List<Company> companies = companyService.getAllCompanies();
        final List<CompanyGetResponse> responses = CompanyMapper.toGetResponse(companies);

        return ResponseEntity.ok(responses);

    }


    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable("companyId") Integer companyId) {
        companyService.deleteCompanyById(companyId);
        return new ResponseEntity<String>("Company deleted", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCompany(@RequestBody CompanyUpdateRequest request){
        final Company company = companyService.updateCompany(request);
        final CompanySavedResponse response = CompanyMapper.toSavedResponse(company);

        return ResponseEntity.ok(response);
    }

}
