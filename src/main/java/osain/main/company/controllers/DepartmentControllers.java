package osain.main.company.controllers;


import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import osain.main.company.services.DepartmentServices;
import osain.main.company.entites.Department;


@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor

public class DepartmentControllers {

	private final DepartmentServices depservices;
		
		@GetMapping
		public ResponseEntity<List<Department>> getAll(){
			return ResponseEntity.ok(depservices.getAllDepartment());
		}
		
		@PostMapping
		public ResponseEntity<Department> create(@RequestBody Department department){
			return ResponseEntity.ok(depservices.createDepartment(department));
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Department> getDepartmentById(@PathVariable long id){
		    return ResponseEntity.ok(depservices.getdepartmentbyId(id));
		}
}