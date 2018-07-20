package ua.logos.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	@JsonIgnore
	private Long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	
	@JsonIgnore
	private String password;
	
}
