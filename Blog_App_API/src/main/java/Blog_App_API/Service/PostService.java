package Blog_App_API.Service;

import java.util.List;

import Blog_App_API.Entity.Post;
import Blog_App_API.Payloads.PostDto;

public interface PostService {

	//Create
	
	PostDto createPost(PostDto postDto,Integer userId,Integer CategoryId);
	
	//Update
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//Delete
	
	void deletePost(Integer postId);
	
	//getAllpost
	
	List<PostDto> getAllPost();
	
	//getSingle Post
	
	PostDto getPostById(Integer postId);
	
	//get all posted by Category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posted by User
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//Search Post
	
	List<PostDto> searchposts(String keyword);
}
