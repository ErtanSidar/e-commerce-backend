package essoft.ecommerce.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListDto {
	
    private int id;
	
	private String productName;
	
	private double unitPrice;
	
	private short unitsInStock;
	
	private String quantityPerUnit;
	
	private String imageUrl;
	
	private String categoryName;
	
}
