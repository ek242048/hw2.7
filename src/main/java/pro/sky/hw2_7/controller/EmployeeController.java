package pro.sky.hw2_7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw2_7.model.Employee;
import pro.sky.hw2_7.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping ("/add")
    public Employee add (@RequestParam("firstName") String firstName,
                         @RequestParam ("lastName") String lastName) {
        return employeeService.add( firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam ("lastName") String lastName) {
        return employeeService.remove( firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find (@RequestParam("firstName") String firstName,
                          @RequestParam ("lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/print")
    public List<Employee> print() {
        return employeeService.getAllEmployees();
    }

}
