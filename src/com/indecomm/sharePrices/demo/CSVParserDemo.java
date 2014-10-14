package com.indecomm.sharePrices.demo;
import java.util.Map;

import com.indecomm.sharePrices.parser.Context;
import com.indecomm.sharePrices.parser.MaximumStockPrices;



public class CSVParserDemo {

	public static void main(String args[]) {
		
		Context context = new Context(new MaximumStockPrices());
		Map<String, String> map = context.executeStrategy("src\\com\\indecomm\\sharePrices\\sampleCases\\sample1.csv");
		for(String s : map.keySet()) {
			System.out.print(s + " -> ");
			System.out.println(map.get(s));
		}
	}
}
