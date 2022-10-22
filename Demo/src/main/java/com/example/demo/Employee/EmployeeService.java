package com.example.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository EmployeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository EmployeeRepository) {
        this.EmployeeRepository = EmployeeRepository;
    }

    public List<Employee> getEmployee(){
        return EmployeeRepository.findAll();
    }

    public Employee getEmployeeId(Long id) {
        return EmployeeRepository.findById(id).get();
    }

    public void addEmployee(Employee Employee) {
        EmployeeRepository.save(new Employee(Employee.getNom(),Employee.getPrenom(), Employee.getDept()));
    }
    public void deleteEmployee(Long id){
        EmployeeRepository.deleteById(id);
    }
}
