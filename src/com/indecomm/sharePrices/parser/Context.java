package com.indecomm.sharePrices.parser;
import java.util.Map;

/**
 * 
 * Strategy Design Pattern
 * @author dell
 *
 */
public class Context {

	private ICSVParser parserStrategy;

	public Context(ICSVParser parserStrategy) {
		this.parserStrategy = parserStrategy;
	}
	
	public Map<String, String> executeStrategy(String fileName) {
		return parserStrategy.parse(fileName); 
	}
}
