package essoft.ecommerce.business.abstracts;

import java.util.List;

import essoft.ecommerce.business.dtos.BrandListDto;
import essoft.ecommerce.business.requests.brandRequests.CreateBrandRequest;
import essoft.ecommerce.core.results.DataResult;
import essoft.ecommerce.core.results.Result;

public interface BrandService {
	DataResult<List<BrandListDto>> getAll();
	DataResult<BrandListDto> findByBrandId(int brandId);
	Result add(CreateBrandRequest createBrandRequest);
}
