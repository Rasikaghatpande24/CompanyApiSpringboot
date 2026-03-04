package osain.main.company.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeResponseDto {
	private String name;
	private String email;
	private Double salary;
	private String departmentName;
}
