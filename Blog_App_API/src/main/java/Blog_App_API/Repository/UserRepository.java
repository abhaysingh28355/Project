package Blog_App_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Blog_App_API.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	

}
