package osain.main.company.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import osain.main.company.entites.Department;
import osain.main.company.repositories.DepRepositories;

import java.util.List;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DepartmentServices {
	private final DepRepositories departmentrepositories;
	
	public Department createDepartment(Department department) {
		department.setCreatedAt(LocalDateTime.now());
		return departmentrepositories.save(department);
	}
	
	public List<Department> getAllDepartment(){
		return departmentrepositories.findAll();
	}
	
	public Department getdepartmentbyId(long id) {
		return departmentrepositories.findById(id)
				.orElseThrow(() -> new RuntimeException("Department Not Found"));
	}
	
}
