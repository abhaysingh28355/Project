package Blog_App_API.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer CategoryId;
	private String CategoryName;
	private String Categorydescription;
}
