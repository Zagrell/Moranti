package gruppe1.moranti.restcontrollers;

import gruppe1.moranti.models.Employee;
import gruppe1.moranti.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Employees {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).get();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @PostMapping("/employees/{id}")
    public Employee addEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @PutMapping("/employees/{id}")
    public String updateEmployeeById(@PathVariable Long id, @RequestBody Employee employeeToUpdateWith) {
        if (employeeRepository.existsById(id)) {
            employeeToUpdateWith.setId(id);
            employeeRepository.save(employeeToUpdateWith);
            return "Car was created";
        } else {
            return "Car not found";
        }
    }

    @DeleteMapping("/employees/{id}")
    public void deleteCarByCarNumber(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }



}