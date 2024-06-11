package Blog_App_API.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Blog_App_API.Entity.category;
import Blog_App_API.Exception.ResourceNotFoundException;
import Blog_App_API.Payloads.CategoryDto;
import Blog_App_API.Repository.CategoryRepo;
import Blog_App_API.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	public CategoryRepo categoryRepo;
	
	@Autowired
	public ModelMapper modelmapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		category cat = this.modelmapper.map(categoryDto, category.class);
		category add = this.categoryRepo.save(cat);
		return this.modelmapper.map(add, CategoryDto.class);
	}

	@Override
	public CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId) {
		category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		cat.setCategoryName(categoryDto.getCategoryName());
		cat.setCategorydescription(categoryDto.getCategorydescription());
		category Update = this.categoryRepo.save(cat);
		return this.modelmapper.map(Update, CategoryDto.class);
	}

	@Override
	public Void DeleteCategory(Integer categoryId) {
		category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		this.categoryRepo.delete(cat);
		return null;
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		return this.modelmapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<category> categories = this.categoryRepo.findAll();
		List<CategoryDto> CatDTO = categories.stream().map((cat)->this.modelmapper.map(categories, CategoryDto.class)).collect(Collectors.toList());

		return CatDTO;
	}

}
