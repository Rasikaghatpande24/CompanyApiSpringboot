package osain.main.company.services;
import osain.main.company.entites.Employee;

public interface EmployeUpdateService {
	Employee updateEmployee(Long id, Employee updatedEmployee);

    void deleteEmployee(Long id);
}
