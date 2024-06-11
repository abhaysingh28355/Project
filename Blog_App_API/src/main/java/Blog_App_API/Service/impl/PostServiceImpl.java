package Blog_App_API.Service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Blog_App_API.Entity.Post;
import Blog_App_API.Entity.User;
import Blog_App_API.Entity.category;
import Blog_App_API.Exception.ResourceNotFoundException;
import Blog_App_API.Payloads.PostDto;
import Blog_App_API.Repository.CategoryRepo;
import Blog_App_API.Repository.PostRepo;
import Blog_App_API.Repository.UserRepository;
import Blog_App_API.Service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer CategoryId) {
		
		User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "user Id", userId));
		
		category cat= this.categoryRepo.findById(CategoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", CategoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("Default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(cat);
		Post newPost=this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "pst Id", postId));
		post.setTitle(post.getTitle());
		post.setContent(post.getContent());
		post.setImageName(post.getImageName());
		Post save = this.postRepo.save(post);
		return this.modelMapper.map(save, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "pst Id", postId));
		this.postRepo.deleteById(postId);
	}

	@Override
	public List<PostDto> getAllPost() {
	
		List<Post> findAll = this.postRepo.findAll();
		List<PostDto> collect = findAll.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "post Id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		List<PostDto> postDto = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "user Id", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
		
	}

	@Override
	public List<PostDto> searchposts(String keyword) {
		List<Post> posts = this.postRepo.searchByTitle("%"+keyword+"%");
		List<PostDto> collect = posts.stream().map((post)-> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

}
