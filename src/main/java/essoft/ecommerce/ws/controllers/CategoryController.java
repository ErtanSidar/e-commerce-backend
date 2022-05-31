package essoft.ecommerce.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import essoft.ecommerce.business.abstracts.CategoryService;
import essoft.ecommerce.business.dtos.CategoryListDto;
import essoft.ecommerce.business.requests.categoryRequests.CreateCategoryRequest;
import essoft.ecommerce.core.results.DataResult;
import essoft.ecommerce.core.results.Result;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CategoryListDto>> getAll() {
		return this.categoryService.getAll();
	}
	
	@GetMapping("/findbyId/{categoryId}")
	public DataResult<CategoryListDto> findById(@PathVariable int categoryId) {
		return this.categoryService.findByCategoryId(categoryId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateCategoryRequest createCategoryRequest) {
		return this.categoryService.add(createCategoryRequest);
	}
	
	

}
