package Blog_App_API.Service;

import java.util.List;

import Blog_App_API.Payloads.CategoryDto;

public interface CategoryService {

	//Create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//Update
	CategoryDto UpdateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//Delete
	Void DeleteCategory(Integer categoryId);
	//get
	CategoryDto getCategory(Integer categoryId);
	//GetAll
	List<CategoryDto> getCategories();
}
