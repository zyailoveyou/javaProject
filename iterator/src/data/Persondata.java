package data;

import java.util.ArrayList;

public  class Persondata {
	

	private ArrayList<Dayinformation> dayinformation;
	private String name;
	
	public Persondata(ArrayList<Dayinformation> info) {		
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
