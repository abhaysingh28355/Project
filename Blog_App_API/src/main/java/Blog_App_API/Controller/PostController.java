package Blog_App_API.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Blog_App_API.Entity.Post;
import Blog_App_API.Payloads.ApiResponse;
import Blog_App_API.Payloads.PostDto;
import Blog_App_API.Service.FileService;
import Blog_App_API.Service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	@Value("${project.Image}")
	private String path;

	// Create
	@PostMapping("/user/{userId}/Category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer CategoryId) {
		PostDto createPost = this.postService.createPost(postDto, userId, CategoryId);

		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}

	// get By user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {
		List<PostDto> postsByUser = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);
	}

	// get By Category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
		List<PostDto> postsBycategory = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postsBycategory, HttpStatus.OK);
	}

	// get all Post
	@GetMapping("/post")
	public ResponseEntity<List<PostDto>> getAllPost() {
		List<PostDto> allPost = this.postService.getAllPost();
		return new ResponseEntity<List<PostDto>>(HttpStatus.OK);
	}

	// get Post details By Id
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
		PostDto postById = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postById, HttpStatus.OK);
	}

	// deleting post
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletPost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("Post is Successful delete !!", true);
	}

	// Update post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);

	}
	//Search
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> SearchPostById(@PathVariable("keyword") String keywords){
		List<PostDto> searchposts = this.postService.searchposts(keywords);
		return new ResponseEntity<List<PostDto>>(searchposts,HttpStatus.OK);
	}
	//Image Upload File
	@PostMapping("/posts/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadimage(@RequestParam("image") MultipartFile image,@PathVariable Integer postId) throws IOException{
		String fileName = this.fileService.uploadimage(path, image);
		PostDto postDto = this.postService.getPostById(postId);
		postDto.setImageName(fileName);
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}

}
