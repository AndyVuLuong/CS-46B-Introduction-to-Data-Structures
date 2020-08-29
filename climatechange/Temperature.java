package climatechange;

public class Temperature implements ITemperature, Comparable<ITemperature>
{
	private String country;
	private String country3LetterCode;
	private String month;
	private int year;
	private double temperature;
	public Temperature(double temperature, int year, String month, String country, String country3LetterCode)
	{
		this.country=country;
		this.country3LetterCode=country3LetterCode;
		this.month=month;
		this.year=year;
		this.temperature=temperature;
	}
	 public String getCountry() { // get the name of the country
		 return country;
	 }
	 public String getCountry3LetterCode() { // get the 3-letter code of the country
		 return country3LetterCode;
	 }
	 public String getMonth() { // get the month
		 return month;
	 }
	 public int getYear() { // get the year
		 return year;
	 }
	 public double getTemperature(boolean getFahrenheit) { // get temperature; input parameter of false = return Celsius value)
			if(getFahrenheit) {
				double a = (temperature/5*9) + 32;
				temperature = a;
				return temperature;
			}
			return temperature;
	 }
		public String toString() {
			return temperature + " " +  year + " " + month + " " + country + " " + country3LetterCode;
		}
		
		//General equals method
		public boolean equals(Object x) {
			Temperature that = (Temperature)x;
			return this.compareTo(that) == 0;
			//if(this.getCountry() == that.getCountry()) return true;
			//else return false;
		}
		
		//Checks temperature, then country, then year, then month
		public int compareTo(ITemperature o) {
			if(this.temperature < o.getTemperature(false)) return -1;
			if(this.temperature > o.getTemperature(false)) return 1;
			if(this.temperature == o.getTemperature(false));
				if(this.country.compareTo(o.getCountry()) < 0) return -1;
				if(this.country.compareTo(o.getCountry()) > 0) return 1;
				if(this.country.compareTo(o.getCountry()) == 0);
					if(this.year < o.getYear()) return -1;
					if(this.year > o.getYear()) return 1;
					if(this.year == o.getYear());
						if(this.convertMonth(this.month) < this.convertMonth(o.getMonth())) return -1;
						if(this.convertMonth(this.month) > this.convertMonth(o.getMonth())) return 1;
						if(this.convertMonth(this.month) == this.convertMonth(o.getMonth())) return 0;
			return 0;
		}
		 
		//Potential hashSet
		public int hashCode() {
			return year + (int)temperature;
		}
		
		//To check month in compareTo
		public int convertMonth(String month) {
			int intMonth;
			 if(month.equals("Jan")) return intMonth = 12;
			 if(month.equals("Feb")) return intMonth = 11;
			 if(month.equals("Mar")) return intMonth = 10;
			 if(month.equals("Apr")) return intMonth = 9;
			 if(month.equals("May")) return intMonth = 8;
			 if(month.equals("Jun")) return intMonth = 7;
			 if(month.equals("Jul")) return intMonth = 6;
			 if(month.equals("Aug")) return intMonth = 5;
			 if(month.equals("Sep")) return intMonth = 4;
			 if(month.equals("Oct")) return intMonth = 3;
			 if(month.equals("Nov")) return intMonth = 2;
			 if(month.equals("Dec")) return intMonth = 1;
			 else return 0;
		}
}
