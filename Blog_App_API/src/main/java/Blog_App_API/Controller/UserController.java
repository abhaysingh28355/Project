package Blog_App_API.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Blog_App_API.Payloads.ApiResponse;
import Blog_App_API.Payloads.UserDto;
import Blog_App_API.Service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userservice;

	// Post-Creating User
	@PostMapping("/")
	public ResponseEntity<UserDto> createuser(@Valid @RequestBody UserDto userDto) {
		UserDto createUser = this.userservice.createUser(userDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	// PUT-Update-User
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> UpdateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable("userId") Integer uId) {
		UserDto updateUser = this.userservice.updateUser(userDto, uId);
		return ResponseEntity.ok(updateUser);
	}

	// Delete-User
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> DeleteUser(@PathVariable("userId") Integer uId) {
		this.userservice.deleteUser(uId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User delete successful", true), HttpStatus.OK);
	}

	// Get-User-Id
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userservice.getAllUser());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer uId) {
		return ResponseEntity.ok(this.userservice.getUserById(uId));
	}
}
