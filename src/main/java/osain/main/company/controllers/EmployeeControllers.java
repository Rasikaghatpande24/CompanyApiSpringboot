package osain.main.company.controllers;

import osain.main.company.dto.EmployeeRequestDto;
import osain.main.company.dto.EmployeeResponseDto;
import osain.main.company.entites.Employee;
import osain.main.company.services.EmployeeServices;
import osain.main.company.dto.CustomDto;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeControllers {

    private final EmployeeServices employeeServices;

    // CREATE Employee
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(
            @RequestBody EmployeeRequestDto dto) {

        return ResponseEntity.ok(
                employeeServices.createEmployee(dto)
        );
    }

    // GET employees by department with pagination 
    @GetMapping
    public Page<EmployeeResponseDto> getEmployeesByDepartment(
            @RequestParam Long departmentId,
            Pageable pageable) {

        return employeeServices
                .getEmployeesByDepartment(departmentId, pageable);
    }
    
    
    //Get employees by empId 
   @GetMapping("/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable Long id) {
	   return employeeServices.getEmployeeById(id);

   }
    		
   
    
    @GetMapping("/details")
    public List<CustomDto> getEmployeeDepartmentDetails() {
    		return employeeServices.getEmployeeDepartmentData();
    }
    //Update Mapping 
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        Employee updatedEmployee = employeeServices.updateEmployee(id, employee);

        return ResponseEntity.ok(updatedEmployee);
    }
    
    //Delete Mapping 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

        employeeServices.deleteEmployee(id);

        return ResponseEntity.ok("Employee deleted successfully");
    }
    
    
	/*
	 * // bulk mapping for many employees to add through the post request
	 * 
	 * @PostMapping("/bulk") public ResponseEntity<List<EmployeeResponseDto>>
	 * createEmployeesBulk(
	 * 
	 * @RequestBody List<EmployeeRequestDto> dtos) {
	 * 
	 * return ResponseEntity.ok( employeeServices.createEmployeesBulk(dtos) ); }
	 */
    
    
    
    
}