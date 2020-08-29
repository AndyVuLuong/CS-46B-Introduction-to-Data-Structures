package climatechange;
import java.util.*;
import java.io.*;
import java.io.*;

public class WeatherIO implements IWeatherIO
{
	 public ArrayList<ITemperature> readDataFromFile(String fileName)
		// read all data from the weather data file
		 {
			 File inputFile= new File("src/data/world_temp_2000-2016.csv");
			 ArrayList<ITemperature> temp= new ArrayList<ITemperature>();
			try {
				Scanner scanner = new Scanner(inputFile);
				scanner.nextLine();
				while(scanner.hasNextLine())
			    {
			        String line = scanner.nextLine();
			        String[] data = line.split(", ");
			        double tempRead = Double.parseDouble(data[0]);
			        int year = Integer.parseInt(data[1]);
			        String month = data[2];
			        String country = data[3];
			        String countryCode = data[4];
			        ITemperature t = new Temperature(tempRead, year, month, country, countryCode);
			        temp.add(t);

			    }

			    scanner.close();
			    return temp;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			 return temp;
		 }
	 
	 public void writeSubjectHeaderInFile(String filename, String subject) 
	 {
		 //Creates the file and adds subject and topic
		try {;
			File file = new File(filename);
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			if(subject.contains("C1")) bw.write(subject + "\n" + "Temperature Delta, Year Delta, Month, Country, Country_Code" + "\n");
			else bw.write(subject + "\n" + "Temperature, Year, Month, Country, Country_Code" + "\n");
			bw.close();
			
		} catch(IOException e) {System.out.println("no"); }
	    
	 }
	 // 1. write the subject header before dumping data returned from each ClimateAnalyzer method
	 // 2. a subject header is to be written for each ClimateAnalyzer method call
	 
	 public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) {
		 
		 //Appends the data onto the new file
		 try { FileWriter fw = new FileWriter(filename, true);
		 				for(ITemperature t : theWeatherList) {
		 				//Converts celsius to fahrenheit and converts both to two decimals places
						double c = t.getTemperature(false);
						double c2Decimal = Math.round(c * 100.0) / 100.0;
						double f = t.getTemperature(true);
						double f2Decimal = Math.round(f * 100.0) / 100.0;
						
						//Adds temperature, year, month, country, countryCode
						 fw.write(String.valueOf(c2Decimal) + "(C) "); 
						 fw.write(String.valueOf(f2Decimal) + "(F), "); 
						 fw.write(t.getYear() + ", ");
						 fw.write(t.getMonth() + ", ");
						 fw.write(t.getCountry() + ", ");
						 fw.write(t.getCountry3LetterCode() + " ");
						 fw.write("\n");
		 				} 
		 fw.close();
		 } catch (IOException e) { System.out.println("no"); }

		 
	 }
	 // 1. file name should be called “taskXX_climate_info.csv” where XX will be replaced by the task id: A1, A2, etc
	 // 2. use this method to store the temperature info (for each Climate Analyzer task)
	 // a) one row for each temperature data object (i.e. all fields in one row (each comma delimited) )
	 // b) similar to the original input data file)
	 // 3. temperature value should be formatted to use a maximum of 2 decimal places
	 // 4. temperature field should also show the Fahrenheit value (using decimal rules above)
	 // a)
}
