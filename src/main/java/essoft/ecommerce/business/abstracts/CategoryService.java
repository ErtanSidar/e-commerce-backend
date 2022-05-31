package essoft.ecommerce.business.abstracts;

import java.util.List;

import essoft.ecommerce.business.dtos.CategoryListDto;
import essoft.ecommerce.business.requests.categoryRequests.CreateCategoryRequest;
import essoft.ecommerce.core.results.DataResult;
import essoft.ecommerce.core.results.Result;

public interface CategoryService {
	DataResult<List<CategoryListDto>> getAll();
	DataResult<CategoryListDto> findByCategoryId(int categoryId);
	Result add(CreateCategoryRequest createCategoryRequest);
}
