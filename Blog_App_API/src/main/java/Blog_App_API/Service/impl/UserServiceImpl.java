package Blog_App_API.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Blog_App_API.Entity.User;
import Blog_App_API.Exception.ResourceNotFoundException;
import Blog_App_API.Payloads.UserDto;
import Blog_App_API.Repository.UserRepository;
import Blog_App_API.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		 
		User user = this.dtoToUser(userDto);
		User saveuser = this.userRepo.save(user);
		return this.userToDto(saveuser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userid) {
		// TODO Auto-generated method stub
//		User user = this.userRepo.findById(userid).orElseThrow(e->new ResourceNotFoundException("user","id",userId));
		User user = this.userRepo.findById(userid).orElseThrow(()-> new ResourceNotFoundException("User", "id", userid));
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User saveuser1 = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(saveuser1);
		return userDto1; 
				
	}

	@Override
	public UserDto deleteUser(Integer userid) {
		User user = this.userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("User", "id", userid));
		this.userRepo.delete(user);
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
	 
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
	
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	private User dtoToUser(UserDto userDto) {
		
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
	}
	private UserDto userToDto(User user) {
		
		UserDto userdto = this.modelMapper.map(user, UserDto.class);
//		userdto.setId(user.getId());
//		userdto.setName(user.getName());
//		userdto.setPassword(user.getPassword());
//		userdto.setEmail(user.getEmail());
//		userdto.setAbout(user.getAbout());
		return userdto;
		
	}
}
