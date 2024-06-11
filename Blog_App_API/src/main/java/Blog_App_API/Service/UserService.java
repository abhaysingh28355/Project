package Blog_App_API.Service;


import java.util.List;

import Blog_App_API.Payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer id);
	UserDto deleteUser(Integer id);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUser();
}
