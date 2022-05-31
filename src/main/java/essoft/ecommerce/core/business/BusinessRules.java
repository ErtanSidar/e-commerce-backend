package essoft.ecommerce.core.business;

import essoft.ecommerce.core.results.Result;

public class BusinessRules {
	
	public static Result run(Result ...logics) {
		for (Result logic : logics) {
			if(!logic.isSuccess()) {
				return logic;
			}
		}
		return null;
	}
	
}
