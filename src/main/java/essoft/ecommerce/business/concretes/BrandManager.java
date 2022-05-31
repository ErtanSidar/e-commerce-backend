package essoft.ecommerce.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import essoft.ecommerce.business.abstracts.BrandService;
import essoft.ecommerce.business.constants.Messages;
import essoft.ecommerce.business.dtos.BrandListDto;
import essoft.ecommerce.business.requests.brandRequests.CreateBrandRequest;
import essoft.ecommerce.core.mapping.ModelMapperService;
import essoft.ecommerce.core.results.DataResult;
import essoft.ecommerce.core.results.ErrorDataResult;
import essoft.ecommerce.core.results.Result;
import essoft.ecommerce.core.results.SuccessDataResult;
import essoft.ecommerce.core.results.SuccessResult;
import essoft.ecommerce.dataAccess.abstracts.BrandDao;
import essoft.ecommerce.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {
	
	private BrandDao brandDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		super();
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<BrandListDto>> getAll() {
		List<Brand> brandList =this.brandDao.findAll();
		List<BrandListDto> response = brandList.stream()
				.map(brand -> modelMapperService.forDto()
				.map(brand, BrandListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<BrandListDto>>(response);

	}

	@Override
	public DataResult<BrandListDto> findByBrandId(int brandId) {
		if(brandDao.existsById(brandId)) {
			Brand brand = this.brandDao.findByBrandId(brandId);
			BrandListDto response = this.modelMapperService.forDto().map(brand,BrandListDto.class);
			return new SuccessDataResult<>(response);
		}else 
			
			return new ErrorDataResult<>("id bulunamadı");
	}

	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandDao.save(brand);
		return new SuccessResult(Messages.brandAdded);
	}

}
