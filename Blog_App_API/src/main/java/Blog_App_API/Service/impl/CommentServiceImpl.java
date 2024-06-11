package Blog_App_API.Service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import Blog_App_API.Entity.Comment;
import Blog_App_API.Entity.Post;
import Blog_App_API.Exception.ResourceNotFoundException;
import Blog_App_API.Payloads.CommentDto;
import Blog_App_API.Repository.CommentRepo;
import Blog_App_API.Repository.PostRepo;
import Blog_App_API.Service.CommentService;

public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "post Id", postId));
		Comment comment = this.modelMapper.map(post, Comment.class);
		comment.setPost(post);
		Comment save = this.commentRepo.save(comment);
		return this.modelMapper.map(save, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer CommentId) {
		// TODO Auto-generated method stub
		Comment con = this.commentRepo.findById(CommentId).orElseThrow(()->new ResourceNotFoundException("Comment", "Comment Id", CommentId));
		this.commentRepo.delete(con);
	}

}
