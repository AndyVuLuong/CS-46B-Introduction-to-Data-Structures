package climatechange;
import java.util.*;
import java.io.*;
public class ClimateAnalyzer extends WeatherIO implements IClimateAnalyzer {
	
	 // TASK A-1
	 // for all data that matches the specified month, get the lowest temperature reading
	 public ITemperature getLowestTempByMonth(String country, int month) {
		 ArrayList<ITemperature> temp = readDataFromFile(""); //Reads File
		 
		 Double min = Double.MAX_VALUE; String convertedMonth = this.convertMonth(month); ITemperature res = null;
		  for(ITemperature c : temp){
		    if(c.getCountry().equals(country) && (c.getMonth().equals(convertedMonth)) && c.getTemperature(false) < min){
		    	min = c.getTemperature(false); res = c; }
		  } 
		  return res;
	 }
	 
	// TASK A-1 
	// for all data that matches the specified month, get the highest temperature reading
	public ITemperature getHighestTempByMonth(String country, int month) {
		 ArrayList<ITemperature> temp = readDataFromFile("");
		 
		 Double max = -10000.0;  String convertedMonth = this.convertMonth(month); ITemperature res = null; //for some reason max = Double.MIN_VALUE is not accepted
		 for(ITemperature c : temp){
			 if(c.getCountry().equals(country) && (c.getMonth().equals(convertedMonth)) && c.getTemperature(false) > max){
				 max = c.getTemperature(false); res = c; }
		  }
		 return res;
	 } 
	
	  // TASK A-2     
	  // for all data that matches the specified year, get the lowest temperature reading 	 
	  public ITemperature getLowestTempByYear(String country, int year){
			 ArrayList<ITemperature> temp = readDataFromFile("");
			 Double min = Double.MAX_VALUE; ITemperature res = null;
			 for(ITemperature c : temp){
			    if(c.getCountry().equals(country) && c.getYear() == year && c.getTemperature(false) < min){
			      min = c.getTemperature(false); res = c; }
			 } 
			 return res;
	  }
	  
	  // TASK A-2     
	  // for all data that matches the specified year, get the lowest temperature reading 
	    public ITemperature getHighestTempByYear(String country, int year) {
			 ArrayList<ITemperature> temp = readDataFromFile("");
			 
			 Double max = Double.MIN_VALUE; ITemperature res = null;
			 for(ITemperature c : temp){
			    if(c.getCountry().equals(country) && c.getYear() == year && c.getTemperature(false) > max){
			      max = c.getTemperature(false); res = c; }
			  }  

			  return res;
	    }
	 
	    // TASK A-3     
	    // get all temperature data that fall within the given temperature range     
	    // the set is sorted from lowest to highest temperature     
	    // input parameter values are in Celsius 
	    public TreeSet<ITemperature> getTempWithinRange(String country,  double rangeLowTemp, double rangeHighTemp){     
	    	TreeSet<ITemperature> tree = new TreeSet<ITemperature>();
	    	 ArrayList<ITemperature> temp = readDataFromFile("");
	    	 for(ITemperature t : temp) {
	    		 if(t.getCountry().equals(country) && (t.getTemperature(false) > rangeLowTemp) && (t.getTemperature(false) < rangeHighTemp)) {
	    			 tree.add(t);
	    		 }
	    	 } 
	    	 return tree;
	    }
	    
	    // TASK A-4     
	    // 1. get the lowest temperature reading amongst all data for that country 
	    public ITemperature  getLowestTempYearByCountry(String country) {
			 ArrayList<ITemperature> temp = readDataFromFile(""); //Reads File
			
			 Double min = Double.MAX_VALUE; ITemperature res = null;
			 for(ITemperature c : temp){
			    if(c.getCountry().equals(country) && c.getTemperature(false) < min){
			      min = c.getTemperature(false); res = c; }
			 } 
	    	return res;
	    }
	    
	    // TASK A-4     
	    // 1. get the highest temperature reading amongst all data for that country  
	    public ITemperature  getHighestTempYearByCountry(String country) {
			 ArrayList<ITemperature> temp = readDataFromFile("");
			 
			 Double max = Double.MIN_VALUE; ITemperature res = null;
			 for(ITemperature c : temp){
				 if(c.getCountry().equals(country) && c.getTemperature(false) > max){
					 max = c.getTemperature(false); res = c; }
			 }
			  return res;
		 }

	    // TASK B-1     
	    // 1. the return list is sorted from lowest to highest temperature 
	    public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month){
	    	ArrayList<ITemperature> temp = readDataFromFile(""); //Reads File
			
			//Get an array after month has been factored
			ArrayList<ITemperature> afterMonth = new ArrayList<ITemperature>();
			String convertedMonth = this.convertMonth(month);
			for(ITemperature c : temp) if(c.getMonth().equals(convertedMonth)) afterMonth.add(c);
			
			//Collection Sort to get Temperatures within the Month
		    Collections.sort(afterMonth, new Comparator<ITemperature>() {
				public int compare(ITemperature s1, ITemperature s2) {
					return Double.compare(s1.getTemperature(false), s2.getTemperature(false));
				} });
		    
		    //Checks for Duplicates
		    ArrayList<ITemperature> top10Highest = new ArrayList<ITemperature>();
		    int count = afterMonth.size()-1;
		    while(top10Highest.size() < 10) {
		    	boolean sameCountry = false;
		    	if(top10Highest.size() == 0) {
		    		top10Highest.add(afterMonth.get(count));
		    	} else {
		    		for(int i = 0; i<top10Highest.size(); i++) {
		    			if(afterMonth.get(count).getCountry().equals(top10Highest.get(i).getCountry())) sameCountry = true;
		    	}
		    	if(!sameCountry) top10Highest.add(afterMonth.get(count));
		    } count--;
		    }
		    
		    //Flips from highest to lowest temperature to lowest to highest temperature
		    ArrayList<ITemperature> flip = new ArrayList<ITemperature>();
		    for(int i = top10Highest.size()-1; i >= 0; i--) flip.add(top10Highest.get(i));
		    return flip;	    
		 }
	    
	    // TASK B-1     
	    // 1. the return list is sorted from lowest to highest temperature 
	    public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month){
	    	ArrayList<ITemperature> temp = readDataFromFile(""); //Reads File
			
			//Get an array after month has been factored
			ArrayList<ITemperature> afterMonth = new ArrayList<ITemperature>();
			String convertedMonth = this.convertMonth(month);
			for(ITemperature c : temp) if(c.getMonth().equals(convertedMonth)) afterMonth.add(c);
			  
			//Collection Sort to get Top10Highest
		    Collections.sort(afterMonth, new Comparator<ITemperature>() {
				public int compare(ITemperature s1, ITemperature s2) {
					return Double.compare(s2.getTemperature(false), s1.getTemperature(false));
				} });
		    
		  //Checks for Duplicates
		    ArrayList<ITemperature> top10Lowest = new ArrayList<ITemperature>();
		    int count = afterMonth.size()-1;
		    while(top10Lowest.size() < 10) {
		    	boolean sameCountry = false;
		    	if(top10Lowest.size() == 0) {
		    		top10Lowest.add(afterMonth.get(count));
		    	}
		    	else {
		    		for(int i = 0; i<top10Lowest.size(); i++) {
		    			if(afterMonth.get(count).getCountry().equals(top10Lowest.get(i).getCountry())) {
		    			sameCountry = true;
		    		}
		    	}
		    	if(!sameCountry) {
		    		top10Lowest.add(afterMonth.get(count));
		    	}
		    }
		    count--;
		    }
		    return top10Lowest;   
		 }

	    // TASK B-2     
	    // 1. the return list is sorted from lowest to highest temperature  	 
	    public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(){
	    	ArrayList<ITemperature> temp = readDataFromFile(""); //Reads File
	    	
		    ArrayList<ITemperature> top10Lowest = new ArrayList<ITemperature>(); //Empty
		    TreeSet<ITemperature> treeSet = new TreeSet<ITemperature>(temp); //Using TreeSet over Collection
		    ArrayList<ITemperature> listWithDup = new ArrayList<ITemperature>(treeSet);//Convert to ArrayList
		   
		  //Checks for Duplicates
		    int count = 0;
		    while(top10Lowest.size() < 10) {
		    	boolean sameCountry = false;
		    	if(top10Lowest.size() == 0) {
		    		top10Lowest.add(listWithDup.get(count));
		    	}
		    	else {
		    		for(int i = 0; i<top10Lowest.size(); i++) {
		    			if(listWithDup.get(count).getCountry().equals(top10Lowest.get(i).getCountry())) {
		    			sameCountry = true;
		    		}
		    	}
		    	if(!sameCountry) {
		    		top10Lowest.add(listWithDup.get(count));
		    	}
		    }
		    count++;
		    }
		    return top10Lowest;
		 }
	    
	    // TASK B-2     
	    // 1. the return list is sorted from lowest to highest temperature 
	    public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(){
	    	ArrayList<ITemperature> temp = readDataFromFile(""); //Reads File
	    	
		    ArrayList<ITemperature> top10Highest = new ArrayList<ITemperature>(); //Empty
		    TreeSet<ITemperature> treeSet = new TreeSet<ITemperature>(temp); //Using TreeSet over Collection
		    ArrayList<ITemperature> listWithDup = new ArrayList<ITemperature>(treeSet);//Convert to ArrayList
		    
		    //Check for Duplicates
		    int count = listWithDup.size()-1;
		    while(top10Highest.size() < 10) {
		    	boolean sameCountry = false;
		    	if(top10Highest.size() == 0) {
		    		top10Highest.add(listWithDup.get(count));
		    	}
		    	else {
		    		for(int i = 0; i<top10Highest.size(); i++) {
		    			if(listWithDup.get(count).getCountry().equals(top10Highest.get(i).getCountry())) {
		    			sameCountry = true;
		    		}
		    	}
		    	if(!sameCountry) {
		    		top10Highest.add(listWithDup.get(count));
		    	}
		    }
		    count--;
		    }
		    
		  //Flips from highest to lowest temperature to lowest to highest temperature
		    ArrayList<ITemperature> flip = new ArrayList<ITemperature>();
		    for(int i = top10Highest.size()-1; i >= 0; i--) flip.add(top10Highest.get(i));
		    return flip;
		 }

	    // TASK B-3     
	    // 1. the return list is sorted from lowest to highest temperature    
	    public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange( double lowRangeTemp, double highRangeTemp) {
			 ArrayList<ITemperature> temp = readDataFromFile("");
			 ArrayList<ITemperature> withinRange = new ArrayList<ITemperature>();
			  for(ITemperature c : temp){
			    if((c.getTemperature(false) >= lowRangeTemp) && (c.getTemperature(false) <= highRangeTemp)){
			    	withinRange.add(c);
			    }
			  }
				//Collection Sort to get Top10Highest
			    Collections.sort(withinRange, new Comparator<ITemperature>() {
					public int compare(ITemperature s1, ITemperature s2) {
						return Double.compare(s1.getTemperature(false), s2.getTemperature(false));
					} });
			    return withinRange;
	    }
	    
	    // TASK C-1     
	    // 1. the countries with the largest temperature differences (absolute value) of the same month between 2 given years.     
	    // 2. the return list is sorted from lowest to highest temperature delta 
	    public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2){     
	    	ArrayList<ITemperature> temp = readDataFromFile(""); //Reads File
	    	int deltaYear = Math.abs(year2 - year1);
	    	
			//Get an array after month has been factored
			ArrayList<ITemperature> afterMonth = new ArrayList<ITemperature>();
			String convertedMonth = this.convertMonth(month);
			for(ITemperature c : temp) {
				if(c.getMonth().equals(convertedMonth) & (c.getYear() == year1 || c.getYear() == year2)) 
					afterMonth.add(c);
			}
			
			/* I thought it was to get the temperature difference between two years and including years in between
			 * Attempted to get climate changes only and add them to the new temperature objects
			  
			//Get an array after month and years has been factored
			ArrayList<ITemperature> afterMonth2 = new ArrayList<ITemperature>();
			String convertedMonth2 = this.convertMonth(month);
			for(ITemperature c : temp) {
				if(c.getMonth().equals(convertedMonth2) & (c.getYear() >= year1 && c.getYear() <= year2)) 
					afterMonth2.add(c);
			}
			
			
			
			ArrayList<Double> doubleList = new ArrayList<Double>();
			double total = 0;
			int deltaInner = 0;
			for(int i = 0; i < afterMonth2.size()-1; i = i + deltaYear+1) {
				deltaInner = deltaInner + deltaInner;
				for(int j = i; j < deltaInner; j++) {
					//if(j == afterMonth2.size()-1) break;
					double add = Math.abs((afterMonth2.get(j).getTemperature(false)-afterMonth2.get(j+1).getTemperature(false)));
					total = total + add;
					System.out.println(total);
				}
				//System.out.println(afterMonth.get(i).getCountry());
				//System.out.println(doubleList);
				doubleList.add(total);
				total = 0;
				//deltaYear = deltaYear + deltaYear;
				//System.out.println(doubleList);
			}
			System.out.println(doubleList);
			*/
			
			//Gets the absolute temperature difference and gets rid of any duplicates of month
			ArrayList<ITemperature> singleMonth = new ArrayList<ITemperature>();
			ArrayList<Double> doubleList = new ArrayList<Double>();
			ArrayList<String> stringList = new ArrayList<String>();
			for(int i = 0; i < afterMonth.size()-1; i = i + 2) {
				stringList.add(afterMonth.get(i).getCountry());
				doubleList.add(Math.abs((afterMonth.get(i).getTemperature(false)-afterMonth.get(i+1).getTemperature(false))));
				singleMonth.add(afterMonth.get(i));
			} 
			
			//Creates new Temperature objects to take in temperature, delta difference, month, country, and countryCode
			ArrayList<ITemperature> arr = new ArrayList<ITemperature>();
			for(int i = 0; i < singleMonth.size()-1; i++) {
			Temperature t = new Temperature(doubleList.get(i), deltaYear, singleMonth.get(i).getMonth(), singleMonth.get(i).getCountry(), singleMonth.get(i).getCountry3LetterCode());
			arr.add(t);
			}
			
			//Orders Temperature and converts treeSet to arrayList
			TreeSet<ITemperature> treeSet = new TreeSet<ITemperature>(arr);
			ArrayList<ITemperature> treeSetToArrayList = new ArrayList<ITemperature>(treeSet);
			
			//Gets top 10 highest temperature differences 
			ArrayList<ITemperature> top10 = new ArrayList<ITemperature>();
			for(int i = treeSetToArrayList.size()-1; i > treeSetToArrayList.size()-11; i--) {
				top10.add(treeSetToArrayList.get(i));
			}
			
			//Flips from highest to lowest temperature to lowest to highest temperature
		    ArrayList<ITemperature> flip = new ArrayList<ITemperature>();
		    for(int i = top10.size()-1; i >= 0; i--) flip.add(top10.get(i));
		    return flip;
	    }
	    
	    //Convert int month to String
		public String convertMonth(int month) {
			String stringMonth = "";
			 if(month == 1) return stringMonth = "Jan";
			 if(month == 2) return stringMonth = "Feb";
			 if(month == 3) return stringMonth = "Mar";
			 if(month == 4) return stringMonth = "Apr";
			 if(month == 5) return stringMonth = "May";
			 if(month == 6) return stringMonth = "Jun";
			 if(month == 7) return stringMonth = "Jul";
			 if(month == 8) return stringMonth = "Aug";
			 if(month == 9) return stringMonth = "Sep";
			 if(month == 10) return stringMonth = "Oct";
			 if(month == 11) return stringMonth = "Nov";
			 if(month == 12) return stringMonth = "Dec";
			 else return null;
		}
		
	 public void runClimateAnalyzer() {

		 //Preconditions
		System.out.println("Enter months in int (1-12), temperature in double (celsius), years from 2000-2016, and enter input in the blank line undernerath each demand" + "\n");
		WeatherIO w = new WeatherIO();
		
		//Creates ArrayList for each Task
		ArrayList<ITemperature> answers1A = new ArrayList<ITemperature>();
		ArrayList<ITemperature> answers1A2 = new ArrayList<ITemperature>();
		ArrayList<ITemperature> answers2A = new ArrayList<ITemperature>();
		ArrayList<ITemperature> answers2A2 = new ArrayList<ITemperature>();
		TreeSet<ITemperature> answers3A = new TreeSet<ITemperature>(); //Exception
		ArrayList<ITemperature> answers4A = new ArrayList<ITemperature>();
		ArrayList<ITemperature> answers4A2 = new ArrayList<ITemperature>();
		ArrayList<ITemperature> answers1B = new ArrayList<ITemperature>();
		ArrayList<ITemperature> answers1B2 = new ArrayList<ITemperature>();
		ArrayList<ITemperature> answers2B = new ArrayList<ITemperature>();
		ArrayList<ITemperature> answers2B2 = new ArrayList<ITemperature>();
		ArrayList<ITemperature> answers3B = new ArrayList<ITemperature>();
		ArrayList<ITemperature> answers1C = new ArrayList<ITemperature>();
		
		try {
		//Task 1A
		//Input and ClimateAnalyzerMethod
		System.out.println("Task A1: Lowest and Highest Temperature for a given country and month");
		System.out.println("Enter a country");
		Scanner scanCountry1A = new Scanner(System.in);
		String country1A = scanCountry1A.nextLine();
		System.out.println("Enter a month");
		Scanner scanMonth1A = new Scanner(System.in);
		int month1A = scanMonth1A.nextInt();
		answers1A.add(this.getLowestTempByMonth(country1A, month1A));
		answers1A2.add(this.getHighestTempByMonth(country1A, month1A));
		
		//Output and WeatherIOMethods
		String fileName1A = "src/data/taskA1_climate_info.csv";
		String subject1A = "Task A1: Lowest Temperature for " + country1A + " for the Month of " + this.convertMonth(month1A);
		w.writeSubjectHeaderInFile(fileName1A, subject1A);
		w.writeDataToFile(fileName1A, "0", answers1A);
	
		String subject1A2 = "Task A1: Highest Temperature for " + country1A + " for the Month of " + this.convertMonth(month1A);
		w.writeSubjectHeaderInFile(fileName1A, subject1A2);
		w.writeDataToFile(fileName1A, "1", answers1A2);
		} catch(Exception e) { System.out.println("Invalid Input"); }
		
		try {
		//Task 2A
		//Input and ClimateAnalyzerMethod
		System.out.println("Task A2: Lowest and Highest Temperature for a given country and year");
		System.out.println("Enter a country");
		Scanner scanCountry2A = new Scanner(System.in);
		String country2A = scanCountry2A.nextLine();
		System.out.println("Enter a year");
		Scanner scanYear2A = new Scanner(System.in);
		int year2A = scanYear2A.nextInt();
		answers2A.add(this.getLowestTempByYear(country2A, year2A));
		
		//Output and WeatherIOMethods
		String fileName2A = "src/data/taskA2_climate_info.csv";
		String subject2A = "Task A2: Lowest Temperature for " + country2A + " for the Year of " + year2A;
		w.writeSubjectHeaderInFile(fileName2A, subject2A);
		answers2A2.add(this.getHighestTempByYear(country2A, year2A));
		w.writeDataToFile(fileName2A, "3", answers2A);
		
		String subject2A2 = "Task A2: Highest Temperature for " + country2A + " for the Year of " + year2A;
		w.writeSubjectHeaderInFile(fileName2A, subject2A2);
		w.writeDataToFile(fileName2A, "4", answers2A2);
		} catch(Exception e) { System.out.println("Invalid Input"); }
		
		try {
		//Task 3A
		System.out.println("Task 3A: Temperatures within the temperature range of a country");
		System.out.println("Enter a country");
		Scanner scanCountry3A = new Scanner(System.in);
		String country3A = scanCountry3A.nextLine();
		System.out.println("Enter the starting point of a temperature range");
		Scanner scanRangeLowTemp3A = new Scanner(System.in);
		double rangeLowTemp3A = scanRangeLowTemp3A.nextDouble();
		System.out.println("Enter the ending point of a temperature range");
		Scanner scanRangeHighTemp3A = new Scanner(System.in);
		double rangeHighTemp3A = scanRangeHighTemp3A.nextDouble();
		answers3A = this.getTempWithinRange(country3A, rangeLowTemp3A, rangeHighTemp3A);
		ArrayList<ITemperature> answers3AConverted = new ArrayList<ITemperature>(answers3A);
		
		//Output and WeatherIOMethods
		String fileName3A = "src/data/taskA3_climate_info.csv";
		String subject3A = "Task A3: Lowest Temperature for " + country3A + " for the Range of " +  rangeLowTemp3A + "-" + rangeHighTemp3A;
		w.writeSubjectHeaderInFile(fileName3A, subject3A);
		w.writeDataToFile(fileName3A, "5", answers3AConverted);
		} catch(Exception e) { System.out.println("Invalid Input"); }
		
		try {
		//Task 4A
		//Input and ClimateAnalyzerMethod
		System.out.println("Task A4: Lowest and Highest temperature of a country");
		System.out.println("Enter a country");
		Scanner scanCountry4A = new Scanner(System.in);
		String country4A = scanCountry4A.nextLine();
		answers4A.add(this.getLowestTempYearByCountry(country4A));
		answers4A2.add(this.getHighestTempYearByCountry(country4A));

		//Output and WeatherIOMethods
		String fileName4A = "src/data/taskA4_climate_info.csv";
		String subject4A = "Task A4: Lowest Temperature Year for " + country4A;
		w.writeSubjectHeaderInFile(fileName4A, subject4A);
		w.writeDataToFile(fileName4A, "6", answers4A);
		
		String subject4A2 = "Task A4: Highest Temperature for " + country4A;
		w.writeSubjectHeaderInFile(fileName4A, subject4A2);
		w.writeDataToFile(fileName4A, "7", answers4A2);
		} catch(Exception e) { System.out.println("Invalid Input"); }
		
		
		try {
		//Task 1B
		//Input and ClimateAnalyzerMethod
		System.out.println("Task B1: Top 10 Countries of lowest or highest temperature in a given month");
		System.out.println("Enter a month");
		Scanner scanMonth1B = new Scanner(System.in);
		int month1B = scanMonth1B.nextInt();
		
		answers1B = this.allCountriesGetTop10LowestTemp(month1B);
		answers1B2 = this.allCountriesGetTop10HighestTemp(month1B);

		//Output and WeatherIOMethods
		String fileName1B = "src/data/taskB1_climate_info.csv";
		String subject1B = "Task B1: Top 10 Countries with the Lowest Temperature for " + convertMonth(month1B);
		w.writeSubjectHeaderInFile(fileName1B, subject1B);
		w.writeDataToFile(fileName1B, "8", answers1B);
		
		String subject1B2 = "Task B1: Top 10 Countries with the Highest Temperature for " + convertMonth(month1B);
		w.writeSubjectHeaderInFile(fileName1B, subject1B2);
		w.writeDataToFile(fileName1B, "9", answers1B2);
		} catch(Exception e) { System.out.println("Invalid Input"); }
		
		try {
		//Task 2B
		//Input and ClimateAnalyzerMethod
		System.out.println("Task B2: Top 10 Countries with the Lowest or Highest Temperature (Already Computed) \n");
		answers2B = this.allCountriesGetTop10LowestTemp();
		answers2B2 = this.allCountriesGetTop10HighestTemp();
		
		//Output and WeatherIOMethods
		String fileName2B = "src/data/taskB2_climate_info.csv";
		String subject2B = "Task B2: These are the Top 10 Countries with the Lowest Temperature!";
		w.writeSubjectHeaderInFile(fileName2B, subject2B);
		w.writeDataToFile(fileName2B, "10", answers2B);
		
		String subject2B2 = "Task B2: These are the Top 10 Countries with the Highest Temperature!";
		w.writeSubjectHeaderInFile(fileName2B, subject2B2);
		w.writeDataToFile(fileName2B, "11", answers2B2);
		} catch(Exception e) { System.out.println("Invalid Input"); }
		
		try {
		//Task 3B
		System.out.println("Task B3: All countries informations from lowest to highest temperature within a temperature range.");
		System.out.println("Enter the starting point of a temperature range");
		Scanner scanLowRangeTemp3B = new Scanner(System.in);
		double lowRangeTemp3B = scanLowRangeTemp3B.nextDouble();
		System.out.println("Enter the ending point of a temperature range ");
		Scanner scanHighRangeTemp3B = new Scanner(System.in);
		double highRangeTemp3B = scanHighRangeTemp3B.nextDouble();
		answers3B = this.allCountriesGetAllDataWithinTempRange(lowRangeTemp3B, highRangeTemp3B);
		
		//Output and WeatherIOMethods
		String fileName3B = "src/data/taskB3_climate_info.csv";
		String subject3B = "Task B3: These are all the Countries from least to highest temperature of the given range " + lowRangeTemp3B + "-" + highRangeTemp3B;
		w.writeSubjectHeaderInFile(fileName3B, subject3B);
		w.writeDataToFile(fileName3B, "12", answers3B);
		} catch(Exception e) { System.out.println("Invalid Input"); }
		
		try {
		//Task 1C
		System.out.println("Task C1: Countries with the largest temperature differences (absolute value) of the same month between 2 given years");
		System.out.println("Enter a month");
		Scanner scanMonth1C = new Scanner(System.in);
		int month1C = scanMonth1C.nextInt();
		
		System.out.println("Enter the starting point of a year range (within 2000-2016)");
		Scanner scanYear1C = new Scanner(System.in);
		int year1C = scanYear1C.nextInt();
		System.out.println("Enter the ending point of a year range (within 2000-2016)");
		Scanner scanSecondYear1C = new Scanner(System.in);
		int secondYear1C = scanSecondYear1C.nextInt();
		answers1C = this.allCountriesTop10TempDelta(month1C, year1C, secondYear1C);
		
		//Output and WeatherIOMethods
		String fileName1C = "src/data/taskC1_climate_info.csv";
		String subject1C = "Task C1: These are the Top 10 countries with largest temperature differences (absolute value) of " + month1C + " between the years " + year1C + " and " + secondYear1C;
		w.writeSubjectHeaderInFile(fileName1C, subject1C);
		w.writeDataToFile(fileName1C, "13", answers1C);
		System.out.println("Done!");
		} catch(Exception e) { System.out.println("Invalid Input"); }
		
		/*
		//Close Scans
		scanCountry1A.close();
		scanMonth1A.close();
		scanCountry2A.close();
		scanYear2A.close();
		scanCountry3A.close();
		scanRangeLowTemp3A.close();
		scanRangeHighTemp3A.close();
		scanCountry4A.close();
		scanMonth1B.close();
		scanLowRangeTemp3B.close();
		scanHighRangeTemp3B.close();
		
		scanMonth1C.close();
		scanYear1C.close();
		scanSecondYear1C.close();
		*/
	 }
}
	 // 1. This method starts the climate-change task activities
	 // 2. The ClimateChange methods must be called in the order as listed in the [description section], (first with the Task A
	 // methods, second are the Task B methods, and third are the Task C methods)
	 // 3. For each of the ClimateChange methods that require input parameters, this method must ask the user to
	 // enter the required information for each of the tasks.
	 // 4. Each ClimateAnalyzer method returns data, so the data results must be written to data files
	 
