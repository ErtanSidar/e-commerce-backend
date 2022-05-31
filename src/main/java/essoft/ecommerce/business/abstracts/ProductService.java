package essoft.ecommerce.business.abstracts;

import java.util.List;

import essoft.ecommerce.business.dtos.ProductListDto;
import essoft.ecommerce.business.requests.productRequests.CreateProductRequest;
import essoft.ecommerce.core.results.DataResult;
import essoft.ecommerce.core.results.Result;

public interface ProductService {
	DataResult<List<ProductListDto>> getAll();
	DataResult<ProductListDto> findByProductId(int productId);
	Result add(CreateProductRequest createProductRequest);
}
