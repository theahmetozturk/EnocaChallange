package com.enoca.project.service;

import com.enoca.project.mapper.CompanyMapper;
import com.enoca.project.model.dto.company.request.CompanyCreateRequest;
import com.enoca.project.model.entity.Company;
import com.enoca.project.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;


    /**
     * Yeni bir Company entity nesnesinin oluşturulduğu metoddur.
     *
     * @param request
     * @return
     */
    public Company createCompany(
            CompanyCreateRequest request
    ) {
        Company company = CompanyMapper.mapForSaving(request);

        return companyRepository.save(company);
    }

    /**
     * ID Değeri belirtilen Company entity nesnesini geriye döndüren
     * metoddur.
     *
     * @param companyId
     * @return
     */
    public Company getCompanyById(
            Integer companyId
    ) {
        return companyRepository.findById(companyId)
                .orElseThrow(()-> new RuntimeException("Specified Company Not Found!"));
    }

    /**
     * Geriye bir liste içerisinde veritabanındaki tüm
     * Company entity nesnelerini döndürür.
     * @return
     */
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public void deleteCompany(Integer companyId) {
        companyRepository.delete(companyId);
    }

}
