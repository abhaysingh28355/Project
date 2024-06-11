package Blog_App_API.Payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Blog_App_API.Entity.Comment;
import Blog_App_API.Entity.User;
import Blog_App_API.Entity.category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Integer PostId;
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private category category;
	
	private UserDto user;
	
	 private Set<CommentDto> comments=new HashSet<>();

}
