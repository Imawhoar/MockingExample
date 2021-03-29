package Integration;
import com.example.EmployeeRepository;
import com.example.Employee;

import java.util.List;

public class EmployeeRepo implements EmployeeRepository
{

    List<Employee> m_employees;


    public EmployeeRepo(List<Employee> employees){
        m_employees = employees;
    }

    @Override
    public List<Employee> findAll() {
        return m_employees;
    }

    @Override
    public Employee save(Employee e) {
        String id = e.getId();

        for (int i = 0; i < m_employees.size(); i++) {

            if(m_employees.get(i).getId().equals(id))
            {
                m_employees.set(i, e);

                //Vet inte vad funktionen vill returnera.
                return e;
            }

        }
        m_employees.add(e);
        return e;
    }
}
