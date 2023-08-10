package com.enoca.project.service;

import com.enoca.project.mapper.CompanyMapper;
import com.enoca.project.model.dto.company.request.CompanyCreateRequest;
import com.enoca.project.model.dto.company.request.CompanyUpdateRequest;
import com.enoca.project.model.entity.Company;
import com.enoca.project.repository.CompanyRepository;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    @Autowired
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


    public String deleteCompanyById(Integer companyId){
        Company company = getCompanyById(companyId);
        companyRepository.delete(company);
        return "Deleted";
    }

    public Company updateCompany(CompanyUpdateRequest request){
        Company company = CompanyMapper.mapForUpdate(request);
        return companyRepository.save(company);

    }

}
