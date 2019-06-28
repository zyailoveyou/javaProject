package bag;

import java.util.ArrayList;

import data.Dayinformation;

public class Data2 {
	
	private ArrayList<Dayinformation> dayinformation = new ArrayList<Dayinformation>();
	private String name = null;
	
	public Data2(ArrayList<Dayinformation> info) {		
		this.dayinformation = info;				
	}
		
	public ArrayList<Dayinformation> getDayinformation() {
		return dayinformation;
	}

	public void setDayinformation(ArrayList<Dayinformation> dayinformation) {
		this.dayinformation = dayinformation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
