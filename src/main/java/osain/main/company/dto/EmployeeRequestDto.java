package osain.main.company.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmployeeRequestDto {
	
	@NotBlank
	public String name;
	
	@Email
	public String email;
	
	@NotNull
	public Double salary;
	
	@NotNull
	public Long departmentId;
	
	
}
