package osain.main.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import osain.main.company.entites.Department;

public interface DepRepositories extends JpaRepository<Department, Long> {

}
