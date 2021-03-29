package com.example;



import Integration.EmployeeRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepoTest {

    @Test
    void FindAllTest(){
        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee("1", 125));
        empList.add(new Employee("2", 4225));
        empList.add(new Employee("3", 165));

        EmployeeRepo repo = new EmployeeRepo(empList);

        var allEmpList = repo.findAll();
        assertEquals(3, allEmpList.size());
        assertNotEquals(0, allEmpList.size());

    }

    @Test
    void SaveTest(){
        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee("1", 125));

        EmployeeRepo repo = new EmployeeRepo(empList);

        Employee newEmployee = new Employee("2", 151);

        var result = repo.save(newEmployee);

        assertEquals(newEmployee, result);
        assertNotEquals(null, result);
    }
}
