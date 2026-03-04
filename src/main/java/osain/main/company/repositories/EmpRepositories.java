package osain.main.company.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import osain.main.company.dto.CustomDto;

import org.springframework.data.jpa.repository.JpaRepository;

import osain.main.company.entites.Employee;
import java.util.List; 

public interface EmpRepositories extends JpaRepository<Employee, Long> {
	Page<Employee> findByDepartmentId(Long department_id, Pageable pageable );
	
	@Query("SELECT new osain.main.company.dto.CustomDto(" +
		       "e.name, e.email, e.salary, d.name) " +
		       "FROM Employee e JOIN e.department d")
		List<CustomDto> fetchEmployeeWithDepartment();
}
