package com.interview.Hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorInProductPriceandSoldPrice {

	public static void main(String[] args) {
		List<String> products = Arrays.asList("chocolate", "cheese", "tomato");
		List<Float> productPrices = Arrays.asList(15f,300.90f,23.44f );
		List<String> productSold = Arrays.asList("cheese", "tomato", "chocolate");

		List<Float> soldPrice = Arrays.asList(300.90f,23.44f,10f );


		Map<String, Float> map = new HashMap<>();
		for (int i = 0; i < products.size(); i++) {
			map.put(products.get(i), productPrices.get(i));
		}
		int errorCount =0;
		for (int i = 0; i < productSold.size(); i++) {
			if(map.get(productSold.get(i)).compareTo(soldPrice.get(i))!=0) {
				errorCount++;
			}
		}
		System.out.println(errorCount);
	}
}
