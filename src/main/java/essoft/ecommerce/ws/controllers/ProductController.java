package essoft.ecommerce.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import essoft.ecommerce.business.abstracts.ProductService;
import essoft.ecommerce.business.dtos.ProductListDto;
import essoft.ecommerce.business.requests.productRequests.CreateProductRequest;
import essoft.ecommerce.core.results.DataResult;
import essoft.ecommerce.core.results.Result;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ProductListDto>> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/findById/{productId}")
	public DataResult<ProductListDto> findbyId(@PathVariable int productId) {
		return this.productService.findByProductId(productId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateProductRequest createProductRequest) {
		return this.productService.add(createProductRequest);
	}
	

}
