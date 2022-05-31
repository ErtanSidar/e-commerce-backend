package essoft.ecommerce.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import essoft.ecommerce.business.abstracts.ProductService;
import essoft.ecommerce.business.constants.Messages;
import essoft.ecommerce.business.dtos.ProductListDto;
import essoft.ecommerce.business.requests.productRequests.CreateProductRequest;
import essoft.ecommerce.core.mapping.ModelMapperService;
import essoft.ecommerce.core.results.DataResult;
import essoft.ecommerce.core.results.Result;
import essoft.ecommerce.core.results.SuccessDataResult;
import essoft.ecommerce.core.results.SuccessResult;
import essoft.ecommerce.dataAccess.abstracts.ProductDao;
import essoft.ecommerce.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ProductManager(ProductDao productDao,ModelMapperService modelMapperService) {
		super();
		this.productDao = productDao;
		this.modelMapperService= modelMapperService;	
	}

	@Override
	public DataResult<List<ProductListDto>> getAll() {
		List<Product> productList = this.productDao.findAll();
		List<ProductListDto> response = productList.stream()
				.map(product -> modelMapperService.forDto().map(product, ProductListDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ProductListDto>>(response);
		
	}

	@Override
	public DataResult<ProductListDto> findByProductId(int productId) {
		if(productDao.existsById(productId)) {
			Product product = this.productDao.findByProductId(productId);
			ProductListDto response = this.modelMapperService.forDto().map(product, ProductListDto.class);
				return new SuccessDataResult<>(response);
			
		}else 
			return new SuccessDataResult<>("id bulunamadı");
	}

	@Override
	public Result add(CreateProductRequest createProductRequest) {
		Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
		this.productDao.save(product);
		return new SuccessResult(Messages.productAdded);
	}

}
