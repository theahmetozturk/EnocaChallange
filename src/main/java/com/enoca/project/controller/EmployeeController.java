package com.enoca.project.controller;

import com.enoca.project.mapper.EmployeeMapper;
import com.enoca.project.model.dto.employee.request.EmployeeCreateRequest;
import com.enoca.project.model.dto.employee.request.EmployeeUpdateRequest;
import com.enoca.project.model.dto.employee.response.EmployeeGetResponse;
import com.enoca.project.model.dto.employee.response.EmployeeSavedResponse;
import com.enoca.project.model.entity.Employee;
import com.enoca.project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    // TODO : Yeni bir Employee ekleyen endpoint. API   [OK]
    // TODO : ID Değeri URL'den verilen Employee entity nesnesini geriye döndüren api.
    // TODO : Tüm Employee entity nesnelerini geriye döndüren api.
    // TODO : ID Değeri URL'den verilen Employee entity nesnesini güncelleyen api.
    // TODO : ID Değeri URL'den verilen Employee entity nesnesini silen api.


    @PostMapping
    public ResponseEntity<?> createEmployee(
            @RequestBody EmployeeCreateRequest request
    ) {
        Employee employee = null;

        try {
            employee = employeeService.createEmployee(request);
        } catch (RuntimeException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

        final EmployeeSavedResponse response = EmployeeMapper.toSavedResponse(employee);

        return ResponseEntity.ok(response);

    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployeeById (@PathVariable("employeeId") Integer employeeId){
       /* Employee employee = null;
        try {
            employee = employeeService.getEmployeeById(employeeId);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);*/
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        final List<Employee> employees = employeeService.getAllEmployees();
        final List<EmployeeGetResponse> responses = EmployeeMapper.toGetResponse(employees);

        return ResponseEntity.ok(responses);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Integer employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeUpdateRequest request){
        Employee employee = null;

        try {
            employee = employeeService.updateEmployee(request);
        } catch (RuntimeException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

        final EmployeeSavedResponse response = EmployeeMapper.toSavedResponse(employee);

        return ResponseEntity.ok(response);
    }

}
