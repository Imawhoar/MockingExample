package com.example;

import java.util.List;

import ClassDoubles.BankServiceDouble;
import ClassDoubles.EmployeeRepositoryDouble;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    @Test
    void PayEmployeeTest(){
        BankService bankServiceShellInterface = new BankServiceDouble();
        EmployeeRepository employeeRepositoryShellInterface = new EmployeeRepositoryDouble();
        EmployeeManager manager = new EmployeeManager(employeeRepositoryShellInterface, bankServiceShellInterface);

        //Det finns 6 employees i findall metoden i EmployeeRepositoryDouble
        assertEquals(6, manager.payEmployees());
        assertNotEquals(0, manager.payEmployees());
    }

    @Test
    void MockitoPayEmployeeTest(){

        BankService bankServiceStub = Mockito.mock(BankService.class);
        EmployeeRepository employeeRepositoryStub = Mockito.mock(EmployeeRepository.class);
        EmployeeManager manager = new EmployeeManager(employeeRepositoryStub, bankServiceStub);


        when(employeeRepositoryStub.findAll())
                .thenReturn(List.of(
                        new Employee("1", 120),
                        new Employee("2", 63),
                        new Employee("3", 322),
                        new Employee("4", 621),
                        new Employee("5", 842),
                        new Employee("6", 125)));


        assertEquals(6, manager.payEmployees());
        assertNotEquals(0, manager.payEmployees());
    }




}