package Blog_App_API.Entity;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="category")
@NoArgsConstructor
@Getter
@Setter

public class category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CategoryId;

	private String CategoryName;
	
	private String Categorydescription;
	
	@OneToMany(mappedBy = "category" ,cascade=CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();
}
