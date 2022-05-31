package essoft.ecommerce.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import essoft.ecommerce.business.abstracts.CategoryService;
import essoft.ecommerce.business.constants.Messages;
import essoft.ecommerce.business.dtos.CategoryListDto;
import essoft.ecommerce.business.requests.categoryRequests.CreateCategoryRequest;
import essoft.ecommerce.core.mapping.ModelMapperService;
import essoft.ecommerce.core.results.DataResult;
import essoft.ecommerce.core.results.ErrorDataResult;
import essoft.ecommerce.core.results.Result;
import essoft.ecommerce.core.results.SuccessDataResult;
import essoft.ecommerce.core.results.SuccessResult;
import essoft.ecommerce.dataAccess.abstracts.CategoryDao;
import essoft.ecommerce.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService {
	
	private CategoryDao categoryDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CategoryManager(CategoryDao categoryDao, ModelMapperService modelMapperService) {
		super();
		this.categoryDao = categoryDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<CategoryListDto>> getAll() {
		List<Category> categoryList = this.categoryDao.findAll();
		List<CategoryListDto> response = categoryList.stream()
				.map(category -> modelMapperService.forDto()
				.map(category, CategoryListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<CategoryListDto>>(response);
	}

	@Override
	public DataResult<CategoryListDto> findByCategoryId(int categoryId) {
		if(categoryDao.existsById(categoryId)) {
			Category category = this.categoryDao.findByCategoryId(categoryId);
			CategoryListDto response = this.modelMapperService.forDto().map(category,CategoryListDto.class);
			return new SuccessDataResult<>(response);
		}else 
			
			return new ErrorDataResult<>("id bulunamadı");
	}

	@Override
	public Result add(CreateCategoryRequest createCategoryRequest) {
		Category category = modelMapperService.forRequest().map(createCategoryRequest, Category.class);
		this.categoryDao.save(category);
		return new SuccessResult(Messages.categoryAdded);
	}

}
