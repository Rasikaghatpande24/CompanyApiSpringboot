# CompanyApiSpringboot
I have created a small spring boot project using Jpa Repository to perform CRUD operation for Mysql. I have built this on java , maven hibernate and spring framwrok 
# Imports 
Spring Boot
Hibernate
Maven 
Spring-Data
Spring-Jpa
MySql
Dto Pattern
Pagination
Rest Api

# Features
Create Employees 
Create Departments
Fetch Employees By Department Id
Fetch Employees By Department
Pagination 
Update Employees
Delete Employees

# Backend 
Java
Spring boot
Spring Data JPA
Hibernate 
# DataBase
MySql

# Tools 
Postman(To test the Apis)
Mysql Workbench
Maven
Git
Github

# Project Structure 
inside src/main/java 
Controller 
  EmployeeController
  DepartmentController
Service 
  EmployeeService
  DepartmentService 
Repository
  EmployeeRepository
  DepartmentRepostiory
DTO
  EmployeeRequestDto
  EmployeeResponseDto
  DepartmentDto
Entity
  Employee
  Department
Exception Handling
  Runtime Exception


# Apis 
# Employee Apis
  Create Employee (POST Mapping)
    Through Employeerepository and employee requestemployeedto and employeeresponsedto we           provide the logic to provide the db with the proper data and we get to see only the             specific data after being protectd through.
    
  Get Employees by Id (GET Mapping)
    in this we fetch employee id through the user and provide all the employee detils of that       id along with department name.
    
  Get Employees by Department Id (Get Mapping)
    In this we fetch department id from department repository and then get only those employees     who have that specific department Id.
  Get Employees By Department (GET Mapping) 
    In this we provide join column data based on custonDto of employees and department. WE use Innner Join in this.
    
  Update Employees (PUT Mapping)
    In this we pass the id parameter and check if the id exist already if yes then we alter the     data of employees provided by the User/Postman/Frontend.
    
  Delete Employees (DELETE Mapping)
    In this we delete the employee based on the id provided by the User.

# Departments
  Create Departments (POST Mapping)
    In this the Api creates a new Department.The createdAt field is automatically set using         LocalDateTime.now().The department is stored in the database using the repository.

  Get All Departments (GET Mapping)
    This API returns the list of all departments stored in the database.It retrieves all            department records using the DepartmentRepository. 
  Get Department by Id (Get Mapping) 
    This API retrieves a department based on the department ID provided by the user.If the          department exists, the department details are returned. Otherwise, an exception is thrown.
    
    
# MySql 
  Employee Entity 
    id (auto-generated)
    name (notBlank)
    email (unique)
    salary (notBlank)

  Department Entity 
    id (auto-generated)
    code (notBlank)
    createdAt (localDateTime)
    name (notBlank)
    

# Concepts Implemented 
  DTO Pattern 
  Entity Relationship 
  Pagination Using Pageable
  Custion JPQL Queries
  Restful API Design 




# Future Improvements 
  Add Authentication(JWT)

# Author 
  Rasika Ghatpande


  
    

  
