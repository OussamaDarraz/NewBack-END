package com.example.demo.Employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class EmployeeController {
    private final EmployeeService EmployeeService;
    private Long id;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired

    public EmployeeController(EmployeeService EmployeeService) {
        this.EmployeeService = EmployeeService;
    }
    @GetMapping(path = "api/Emp")
    public List<com.example.demo.Employee.Employee> getEmployee(){
        return EmployeeService.getEmployee();
    }
    @GetMapping(path = "api/Emp/{id}")
    public Employee getEmployeeId(@PathVariable Long id){
       return EmployeeService.getEmployeeId(id);
    }
    @PostMapping(path = "/api/Emp/add")
    public void addEmployee(@RequestBody @Validated Employee Employee){
        EmployeeService.addEmployee(Employee);

    }
    @DeleteMapping(path = "/api/v1/Employee/delete/{id}")
    public void deleteEmployeeId(@PathVariable Long id){
        EmployeeService.deleteEmployee(id);
    }

    //oussama Update  definition with repository





    @PutMapping(path = "/api/Emp/update/{id}")

    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = EmployeeService.getEmployeeId(id);
        updateEmployee.setDept(employeeDetails.getDept());
        updateEmployee.setPrenom(employeeDetails.getPrenom());
        updateEmployee.setNom(employeeDetails.getNom());

        employeeRepository.save(updateEmployee);
    }
    @DeleteMapping(path = "/api/Employee/delete/{id}")
    public void deleteEmployee(@PathVariable long id){

        Employee employee = EmployeeService.getEmployeeId(id);

        employeeRepository.delete(employee);


    }
}







