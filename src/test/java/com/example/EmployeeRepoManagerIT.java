package com.example;

import ClassDoubles.BankServiceDouble;
import com.example.EmployeeManager;
import Integration.EmployeeRepo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepoManagerIT {

    @Test
    public void IntegrationTest(){

        ArrayList<Employee> empList = new ArrayList<>();

        EmployeeRepo employeeRepo = new EmployeeRepo(empList);
        employeeRepo.save(new Employee("1", 1512));
        employeeRepo.save(new Employee("2", 512));
        employeeRepo.save(new Employee("3", 5152));
        employeeRepo.save(new Employee("4", 122));
        employeeRepo.save(new Employee("5", 6122));

        EmployeeManager empManager = new EmployeeManager(employeeRepo, new BankServiceDouble());
        var result = empManager.payEmployees();

        assertEquals(5, result);
        assertNotEquals(0, result);
    }
}
