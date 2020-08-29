package climatechange;
import java.util.*;
import java.io.*;
interface IClimateAnalyzer {
	 public ITemperature getLowestTempByMonth(String country, int month);
	 // TASK A-1
	 // for all data that matches the specified month, get the lowest temperature reading

	/* public ITemperature getHighestTempByMonth(String country, int month);     
	 // TASK A-1     
	 // for all data that matches the specified month, get the highest temperature reading */
	 
	  public ITemperature getLowestTempByYear(String country, int year);     
	  // TASK A-2     
	  // for all data that matches the specified year, get the lowest temperature reading 
	  
	    public ITemperature getHighestTempByYear(String country, int year);     
	    // TASK A-2     
	    // for all data that matches the specified year, get the highest temperature reading 
	    
	    public TreeSet<ITemperature> getTempWithinRange(String country,  double rangeLowTemp, double rangeHighTemp);     
	    // TASK A-3     
	    // get all temperature data that fall within the given temperature range     
	    // the set is sorted from lowest to highest temperature     
	    // input parameter values are in Celsius 
	    
	    public ITemperature  getLowestTempYearByCountry(String country);      
	    // TASK A-4     
	    // 1. get the lowest temperature reading amongst all data for that country  
	    
	    public ITemperature  getHighestTempYearByCountry(String country);     
	    // TASK A-4     
	    // 1. get the highest temperature reading amongst all data for that country 
	    
	    public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month);     
	    // TASK B-1     
	    // 1. the return list is sorted from lowest to highest temperature 
	    
	    public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month);     
	    // TASK B-1     
	    // 1. the return list is sorted from lowest to highest temperature 
	 
	    public ArrayList<ITemperature> allCountriesGetTop10LowestTemp();     
	    // TASK B-2     
	    // 1. the return list is sorted from lowest to highest temperature 
	 
	    public ArrayList<ITemperature> allCountriesGetTop10HighestTemp();     
	    // TASK B-2     
	    // 1. the return list is sorted from lowest to highest temperature 
	 
	    public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange( double lowRangeTemp, double highRangeTemp     );     
	    // TASK B-3     
	    // 1. the return list is sorted from lowest to highest temperature 
	 
	    public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2);     
	    // TASK C-1     
	    // 1. the countries with the largest temperature differences (absolute value) of the same month between 2 given years.     
	    // 2. the return list is sorted from lowest to highest temperature delta 
	 
	    public void runClimateAnalyzer();
	 // 1. This method starts the climate-change task activities
	 // 2. The ClimateChange methods must be called in the order as listed in the [description section], (first with the Task A
	 // methods, second are the Task B methods, and third are the Task C methods)
	 // 3. For each of the ClimateChange methods that require input parameters, this method must ask the user to
	 // enter the required information for each of the tasks.
	 // 4. Each ClimateAnalyzer method returns data, so the data results must be written to data files
	}