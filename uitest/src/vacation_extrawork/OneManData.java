package vacation_extrawork;

import java.util.ArrayList;

public  class OneManData {
	

	private ArrayList<Approvel_N_Dayinformation> N_dayinformation = new ArrayList<Approvel_N_Dayinformation>();
	private String name = null;
	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OneManData(ArrayList<Approvel_N_Dayinformation> info) {		
		this.N_dayinformation = info;				
	}
		
	public ArrayList<Approvel_N_Dayinformation> getN_dayinformation() {
		return N_dayinformation;
	}

	public void setN_dayinformation(ArrayList<Approvel_N_Dayinformation> dayinformation) {
		this.N_dayinformation = dayinformation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
