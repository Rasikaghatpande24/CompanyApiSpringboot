package osain.main.company.services;
// importing all the inbuilt classes for the service layer to attach and add logic to it 
import osain.main.company.repositories.EmpRepositories;
import osain.main.company.repositories.DepRepositories;
import osain.main.company.entites.Department;
import osain.main.company.entites.Employee;
import osain.main.company.dto.EmployeeResponseDto;
import osain.main.company.dto.EmployeeRequestDto;
import osain.main.company.dto.CustomDto;
import osain.main.company.services.EmployeUpdateService;

import org.springframework.stereotype.Service;
import osain.main.company.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServices implements EmployeUpdateService{

    private final EmpRepositories employeeRepository;
    private final DepRepositories departmentRepository;
    // create a new employee through employee entity 
    public EmployeeResponseDto createEmployee(EmployeeRequestDto dto) {

        Department department = departmentRepository
                .findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);

        Employee saved = employeeRepository.save(employee);

        return new EmployeeResponseDto(
        		saved.getName(),
                saved.getEmail(),
                saved.getSalary(),
                saved.getDepartment().getName()
        );
    }
    
    // getting employee by id 
    public EmployeeResponseDto getEmployeeById(Long id) {

        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return new EmployeeResponseDto(
                employee.getName(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getDepartment().getName());
    }
    
    //Pagination - Get employees by department id 
    public Page<EmployeeResponseDto> getEmployeesByDepartment(Long deptId, Pageable pageable) {

        return employeeRepository
                .findByDepartmentId(deptId, pageable)
                .map(emp -> new EmployeeResponseDto(
                        emp.getName(),
                        emp.getEmail(),
                        emp.getSalary(),
                        emp.getDepartment().getName()
                ));
    }
    
    //Join column- fetching employee details with department data  
    public List<CustomDto> getEmployeeDepartmentData() {
        return employeeRepository.fetchEmployeeWithDepartment();
    }
    
    // Put mapping . updating employees columns automatically wala logic 
	@Override
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		 Employee existingEmployee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

	        // Update fields
	        existingEmployee.setName(updatedEmployee.getName());
	        existingEmployee.setEmail(updatedEmployee.getEmail());
	        existingEmployee.setSalary(updatedEmployee.getSalary());
	        existingEmployee.setDepartment(updatedEmployee.getDepartment());

	        // Save updated employee
	        return employeeRepository.save(existingEmployee);
	}
	
	//Deleting the employee for any reason though this logic 
	 @Override
	    public void deleteEmployee(Long id) {

	        Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

	        employeeRepository.delete(employee);
	    }
	 
	 
		/*
		 * //bulk mapping for employees- logic public List<EmployeeResponseDto>
		 * createEmployeesBulk(List<EmployeeRequestDto> dtos) {
		 * 
		 * List<EmployeeResponseDto> responses = new ArrayList<>();
		 * 
		 * for (EmployeeRequestDto dto : dtos) { responses.add(createEmployee(dto)); }
		 * 
		 * return responses; }
		 */
}