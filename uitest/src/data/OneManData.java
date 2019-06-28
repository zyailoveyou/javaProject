package data;

import java.util.ArrayList;

public  class OneManData {
	

	private ArrayList<Dayinformation> dayinformation = new ArrayList<Dayinformation>();
	private String name = null;
	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OneManData(ArrayList<Dayinformation> info) {		
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
