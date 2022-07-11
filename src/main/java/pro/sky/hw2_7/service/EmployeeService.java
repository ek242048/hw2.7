package pro.sky.hw2_7.service;

import org.springframework.stereotype.Service;
import pro.sky.hw2_7.exceptions.EmployeeAlreadyAddedException;
import pro.sky.hw2_7.exceptions.EmployeeNotFoundException;
import pro.sky.hw2_7.exceptions.EmployeeStorageIsFullException;
import pro.sky.hw2_7.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final static int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        } if (employees.size() < LIMIT){
            employees.put(employee.getFullName(), employee);
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove (String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;

    }

    public Employee find (String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
                return new ArrayList<>(employees.values());
    }
}
