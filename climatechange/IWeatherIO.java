package climatechange;
import java.util.*;
import java.io.*;

interface IWeatherIO {
	 public ArrayList<ITemperature> readDataFromFile(String fileName);
	 // read all data from the weather data file
	 public void writeSubjectHeaderInFile(String filename, String subject);
	 // 1. write the subject header before dumping data returned from each ClimateAnalyzer method
	 // 2. a subject header is to be written for each ClimateAnalyzer method call
	 public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList);
	 // 1. file name should be called “taskXX_climate_info.csv” where XX will be replaced by the task id: A1, A2, etc
	 // 2. use this method to store the temperature info (for each Climate Analyzer task)
	 // a) one row for each temperature data object (i.e. all fields in one row (each comma delimited) )
	 // b) similar to the original input data file)
	 // 3. temperature value should be formatted to use a maximum of 2 decimal places
	 // 4. temperature field should also show the Fahrenheit value (using decimal rules above)
	 // a)
}