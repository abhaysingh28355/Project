package Blog_App_API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Blog_App_API.Payloads.ApiResponse;
import Blog_App_API.Payloads.CategoryDto;
import Blog_App_API.Service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	public CategoryService Categoryservice;

	// Create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = this.Categoryservice.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);

	}

	// Update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> UpdateCategory(@RequestBody CategoryDto categoryDto,
			@PathVariable Integer catId) {
		CategoryDto updateCategory = this.Categoryservice.UpdateCategory(categoryDto, catId);
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);

	}

	// Delete
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) {
		this.Categoryservice.DeleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category message will be Successfully deleted",true), HttpStatus.OK);

	}

	// Get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId) {
		CategoryDto category = this.Categoryservice.getCategory(catId);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);

	}

	// GetAll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategory() {
		List<CategoryDto> categories = this.Categoryservice.getCategories();
		return ResponseEntity.ok(categories);

	}
}
