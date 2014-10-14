package com.indecomm.sharePrices.test;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.indecomm.sharePrices.parser.Context;
import com.indecomm.sharePrices.parser.MaximumStockPrices;

/**
 * 
 * Test cases list :
 * 
 * Normal case
 * Blank file
 * Zero data rows
 * Zero company columns
 * Spaces in month names
 * Spaces in stock prices
 * Incorrect separator
 * Multiple maximum values
 * Blank stock price
 * Duplicate company names
 * Year and month incorrect header
 * Negative stock price
 * Extra elements in a row
 * Lesser elements in a row
 * Non integer value for stock prices
 * Blank line(s) in file
 * Invalid csv file name
 * Price outside range
 * Jumbled header elements
 * Blank company name
 * 
 * 
 * @author dell
 *
 */
public class CSVParserTest {

	private Context context;
	
	@Before
	public void initContext() {
		context = new Context(new MaximumStockPrices());
	}
	
	@Test
	public void testNormalCase() {
		System.out.println("\nNormal case ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample1.csv";
		Map<String, String> map = new TreeMap<String, String>();
		map.put("Company-A", "Mar 2000");
		map.put("Company-B", "Mar 2007");
		map.put("Company-C", "Jun 1993");
		map.put("Company-D", "Apr 2002");
		map.put("Company-E", "Oct 2008");
		assertEquals(new TreeMap<String, String>(context.executeStrategy(fileName)), map);
	}

	@Test
	public void testSingleDataRow() {
		System.out.println("\nSingle data row ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample2.csv";
		Map<String, String> map = new TreeMap<String, String>();
		map.put("Company-A", "Jan 1990");
		map.put("Company-B", "Jan 1990");
		map.put("Company-C", "Jan 1990");
		map.put("Company-D", "Jan 1990");
		map.put("Company-E", "Jan 1990");
		assertEquals(new TreeMap<String, String>(context.executeStrategy(fileName)), map);
	}

	@Test
	public void testNegativeData() {
		System.out.println("\nNegative data ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample5.csv";
		Map<String, String> map = new TreeMap<String, String>();
		map.put("Company-A", "Mar 2000");
		map.put("Company-B", "Mar 2007");
		map.put("Company-C", "Jun 1993");
		map.put("Company-D", "Apr 2002");
		map.put("Company-E", "Oct 2008");
		assertNull(context.executeStrategy(fileName));
	}
	
	@Test
	public void testBlankFile() {
		System.out.println("\nBlank file ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample4.csv";
		assertNull(context.executeStrategy(fileName));
	}
	
	@Test
	public void testDuplicateYearHeading() {
		System.out.println("\nDuplicate year heading ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample3.csv";
		assertNull(context.executeStrategy(fileName));
	}

	@Test
	public void testDuplicateMonthHeading() {
		System.out.println("\nDuplicate month heading ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample11.csv";
		assertNull(context.executeStrategy(fileName));
	}

	@Test
	public void testNoData() {
		System.out.println("\nNo stock price data ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample6.csv";
		assertNull(context.executeStrategy(fileName));
	}
	
	@Test
	public void testNoCompanyName() {
		System.out.println("\nNo company name in header ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample7.csv";
		assertNull(context.executeStrategy(fileName));
	}
	
	@Test
	public void testInvalidMonthName() {
		System.out.println("\nInvalid month name ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample8.csv";
		Map<String, String> map = new TreeMap<String, String>();
		map.put("Company-A", "Mar 2000");
		map.put("Company-B", "Mar 2007");
		map.put("Company-C", "Ju n 1993");
		map.put("Company-D", "Apr 2002");
		map.put("Company-E", "Oct 2008");
		assertEquals(new TreeMap<String, String>(context.executeStrategy(fileName)), map);
	}
	
	@Test
	public void testInvalidPrice() {
		System.out.println("\nInvalid price ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample9.csv";
		assertNull(context.executeStrategy(fileName));
	}

	@Test
	public void testInvalidSeparator() {
		System.out.println("\nInvalid separator ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample10.csv";
		assertNull(context.executeStrategy(fileName));
	}

	@Test
	public void testDuplicateHighestPrice() {
		System.out.println("\nDuplicate highest price ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample12.csv";
		Map<String, String> map = new TreeMap<String, String>();
		map.put("Company-A", "Mar 2000");
		map.put("Company-B", "Mar 2007");
		map.put("Company-C", "Jun 1993");
		map.put("Company-D", "Apr 2002");
		map.put("Company-E", "Oct 2008, Sep 2012");
		assertEquals(new TreeMap<String, String>(context.executeStrategy(fileName)), map);
	}

	@Test
	public void testBlankPrice() {
		System.out.println("\nBlank price ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample13.csv";
		assertNull(context.executeStrategy(fileName));
	}

	@Test
	public void testDuplicateCompanyName() {
		System.out.println("\nDuplicate company name ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample14.csv";
		assertNull(context.executeStrategy(fileName));
	}

	@Test
	public void testInvalidYearOrMonth() {
		System.out.println("\nInvalid year or month ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample15.csv";
		assertNull(context.executeStrategy(fileName));
	}

	@Test
	public void testExtraPricesInRow() {
		System.out.println("\nExtra prices in row ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample16.csv";
		assertNull(context.executeStrategy(fileName));
	}

	@Test
	public void testMissingPricesInRow() {
		System.out.println("\nMissing prices in row ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample17.csv";
		assertNull(context.executeStrategy(fileName));
	}
	
	@Test
	public void testInvalidPrice2() {
		System.out.println("\nInvalid price2 ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample18.csv";
		assertNull(context.executeStrategy(fileName));
	}
	
	@Test
	public void testBlankLine() {
		System.out.println("\nBlank line ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample19.csv";
		Map<String, String> map = new TreeMap<String, String>();
		map.put("Company-A", "Mar 2000");
		map.put("Company-B", "Mar 2007");
		map.put("Company-C", "Jun 1993");
		map.put("Company-D", "Apr 2002");
		map.put("Company-E", "Oct 2008");
		assertEquals(new TreeMap<String, String>(context.executeStrategy(fileName)), map);
	}

	@Test
	public void testInvalidFileName() {
		System.out.println("\nInvalid file name ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample.csv";
		assertNull(context.executeStrategy(fileName));
	}
	
	@Test
	public void testJumbledHeader() {
		System.out.println("\nJumbled headings ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample20.csv";
		Map<String, String> map = new TreeMap<String, String>();
		map.put("Company-A", "Mar 2000");
		map.put("Company-B", "Mar 2007");
		map.put("Company-C", "Jun 1993");
		map.put("Company-D", "Apr 2002");
		map.put("Company-E", "Oct 2008");
		assertEquals(new TreeMap<String, String>(context.executeStrategy(fileName)), map);
	}

	@Test
	public void testOutsideRangePrice() {
		System.out.println("\nOutside range price ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample21.csv";
		assertNull(context.executeStrategy(fileName));
	}
	
	@Test
	public void testMissingCompanyName() {
		System.out.println("\nMissing company name ->");
		String fileName = "src\\com\\indecomm\\sharePrices\\sampleCases\\sample22.csv";
		assertNull(context.executeStrategy(fileName));
	}
}
