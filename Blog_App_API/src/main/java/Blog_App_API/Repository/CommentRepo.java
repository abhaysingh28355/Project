package Blog_App_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Blog_App_API.Entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
