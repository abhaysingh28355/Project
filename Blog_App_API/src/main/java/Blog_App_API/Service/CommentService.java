package Blog_App_API.Service;

import Blog_App_API.Payloads.CommentDto;

public interface CommentService{

	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer CommentId);
}
