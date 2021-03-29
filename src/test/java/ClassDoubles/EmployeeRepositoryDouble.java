package ClassDoubles;

import com.example.Employee;
import com.example.EmployeeRepository;
import java.util.List;

public class EmployeeRepositoryDouble implements EmployeeRepository {

    @Override
    public List<Employee> findAll()
    {
        Employee emp1 = new Employee("1", 2040);
        Employee emp2 = new Employee("2", 2104);
        Employee emp3 = new Employee("3", 50440);
        Employee emp4 = new Employee("4", 104120);
        Employee emp5 = new Employee("5", 2040);
        Employee emp6 = new Employee("6", 1040);
        return List.of(emp1,emp2,emp3,emp4,emp5,emp6);
    }

    @Override
    public Employee save(Employee e) {
        return e;
    }
}
