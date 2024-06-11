package Blog_App_API.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min=4,message="username must be min of 4 character !!")
	private String name;
	@Email(message="your email address is not valid !!")
	private String email;
	@NotEmpty
	@Size(min=3,max=10,message="my password min=3 chars and max=10 chars !!")
	private String password;
	@NotEmpty
	private String about;
}
