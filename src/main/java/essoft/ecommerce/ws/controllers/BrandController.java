package essoft.ecommerce.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import essoft.ecommerce.business.abstracts.BrandService;
import essoft.ecommerce.business.dtos.BrandListDto;
import essoft.ecommerce.business.requests.brandRequests.CreateBrandRequest;
import essoft.ecommerce.core.results.DataResult;
import essoft.ecommerce.core.results.Result;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
	
	//Brand controllers
	private BrandService brandService;

	@Autowired
	public BrandController(BrandService brandService) {
		super();
		this.brandService = brandService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<BrandListDto>> getAll() {
		return this.brandService.getAll();
	}
	
	@GetMapping("/findById/{brandId}")
	public DataResult<BrandListDto>  findById(@PathVariable int brandId) {
		return this.brandService.findByBrandId(brandId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateBrandRequest createBrandRequest) {
		return this.brandService.add(createBrandRequest);
	}
	
	

}
