package com.enoca.project.service;

import com.enoca.project.mapper.EmployeeMapper;
import com.enoca.project.model.dto.employee.request.EmployeeCreateRequest;
import com.enoca.project.model.dto.employee.request.EmployeeUpdateRequest;
import com.enoca.project.model.entity.Company;
import com.enoca.project.model.entity.Employee;
import com.enoca.project.repository.CompanyRepository;
import com.enoca.project.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Employee Entity nesnelerinin yönetildiği servis sınıfıdır.
 *
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    /**
     * Yeni bir employee oluşturmak için kullanılan metoddur.
     *
     * @param request
     * @return
     */
    public Employee createEmployee(
            EmployeeCreateRequest request
    ) {
        Employee employeeEntityToBeSave = EmployeeMapper.mapForSaving(request);

        final Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(()->new RuntimeException("Specified Company Not Found!"));

        employeeEntityToBeSave.setCompany(company);

        return employeeRepository.save(employeeEntityToBeSave);
    }

    /**
     * ID Değeri belirtilen employee entity nesnesini geriye döndüren
     * metoddur.
     *
     * @param employeeId
     * @return
     */

    public Employee getEmployeeById (Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(()-> new RuntimeException("Specified Employee Not Found!"));
    }

    /**
     * Geriye bir liste içerisinde veritabanındaki tüm
     * Employee entity nesnelerini döndürür.
     * @return
     */

    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

    public  String deleteEmployee(Integer id){
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        return "Deleted!";
    }

}
