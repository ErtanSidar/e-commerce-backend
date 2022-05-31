package essoft.ecommerce.business.requests.productRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
	
	private String productName;
	
	private double unitPrice;
	
	private short unitsInStock;
	
	private String quantityPerUnit;
	
	private String imageUrl;
	
	private int categoryId;
}
