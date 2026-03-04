/*
 * package osain.main.company;
 * 
 * import java.util.Optional; import static org.mockito.Mockito.when; import
 * static org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks;
 * import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
 * 
 * import osain.main.company.repositories.EmpRepositories; import
 * osain.main.company.repositories.DepRepositories; import
 * osain.main.company.services.EmployeeServices; import
 * osain.main.company.entites.Department; import
 * osain.main.company.entites.Employee; import
 * osain.main.company.dto.EmployeeResponseDto;
 * 
 * @ExtendWith(MockitoExtension.class) class EmployeeServTest {
 * 
 * @Mock private EmpRepositories employeeRepository;
 * 
 * @Mock private DepRepositories departmentRepository;
 * 
 * @InjectMocks private EmployeeServices employeeService;
 * 
 * @Test void testGetEmployeeById() {
 * 
 * Department department = new Department(1L, "IT", "IT01", null); Employee
 * employee = new Employee(1L, "Rasika", "rasika@test.com", 50000.0,
 * department);
 * 
 * when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
 * 
 * EmployeeResponseDto result = employeeService.getEmployeeById(1L);
 * 
 * assertEquals("Rasika", result.getName()); assertEquals("IT",
 * result.getDepartmentName()); } }
 * 
 */


package osain.main.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import osain.main.company.repositories.EmpRepositories;
import osain.main.company.repositories.DepRepositories;
import osain.main.company.services.EmployeeServices;
import osain.main.company.entites.*;
import osain.main.company.entites.Employee;
import osain.main.company.dto.EmployeeResponseDto;

@ExtendWith(MockitoExtension.class)
class EmployeeServTest {

    @Mock
    private EmpRepositories employeeRepository;

    @Mock
    private DepRepositories departmentRepository;

    @InjectMocks
    private EmployeeServices employeeService;

    @Test
    void testGetEmployeeById() {

        // Create Department object
        Department department = new Department();
        department.setId(1L);
        department.setName("IT");
        department.setCode("IT01");

        // Create Employee object
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Rasika");
        employee.setEmail("rasika@test.com");
        employee.setSalary(50000.0);
        employee.setDepartment(department);

        // Mock repository behavior
        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        // Call service method
        EmployeeResponseDto result = employeeService.getEmployeeById(1L);

        // Verify result
        assertEquals("Rasika", result.getName());
        assertEquals("IT", result.getDepartmentName());
    }
}