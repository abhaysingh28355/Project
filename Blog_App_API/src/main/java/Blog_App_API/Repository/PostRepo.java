package Blog_App_API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Blog_App_API.Entity.Post;
import Blog_App_API.Entity.User;
import Blog_App_API.Entity.category;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(category cat);
	@Query("select p from post p where p.title like:key")
	List<Post> searchByTitle(@Param ("key") String title);
	
}
