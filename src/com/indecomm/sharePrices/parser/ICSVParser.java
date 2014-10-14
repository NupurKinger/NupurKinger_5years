package com.indecomm.sharePrices.parser;
import java.util.Map;

/**
 * 
 * Strategy Design Pattern
 * @author dell
 *
 */
public interface ICSVParser {

	public static final String SEPARATOR = ",";
	
	public Map<String, String> parse(String fileName);
		
}
