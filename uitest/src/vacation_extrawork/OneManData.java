package vacation_extrawork;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.NoSuchElementException;

public  class OneManData {
	


	private String name = null;
	private int id;	
	private ArrayList<Approvel_N_Dayinformation> SpecialSequencialVacationday = new ArrayList<Approvel_N_Dayinformation>();
	private ArrayList<Approvel_N_Dayinformation> N_dayinformation = new ArrayList<Approvel_N_Dayinformation>();
	private ArrayList<Approvel_N_Dayinformation> SpecialSequencialVacationdayTemp = new ArrayList<Approvel_N_Dayinformation>();
		
	public ArrayList<Approvel_N_Dayinformation> getSpecialSequencialVacationday() {
		return SpecialSequencialVacationday;
	}

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
	
	
	public void SeparateSequential_ThreeDay_Dayinformation() throws CloneNotSupportedException {
		
		
		try {
			
			Iterator<Approvel_N_Dayinformation> iteratorN_dayinformation = N_dayinformation.iterator();
			
			while (iteratorN_dayinformation.hasNext()) {
				
				Approvel_N_Dayinformation itn = (Approvel_N_Dayinformation)iteratorN_dayinformation.next();
				
				FindOneLocationIdentical(itn);
							
					if (SpecialSequencialVacationdayTemp.size()>=3) {
											
						Iterator<Approvel_N_Dayinformation> speciaiIterator = SpecialSequencialVacationdayTemp.iterator();
						
						while (speciaiIterator.hasNext()) {
							
							Approvel_N_Dayinformation itS = (Approvel_N_Dayinformation)speciaiIterator.next();
							
							Iterator<Approvel_N_Dayinformation> N_dayinformationIterator = N_dayinformation.iterator();
							
							while (N_dayinformationIterator.hasNext()) {
								
								Approvel_N_Dayinformation itN = (Approvel_N_Dayinformation)N_dayinformationIterator.next();
				   				
								Calendar calendar1 = Calendar.getInstance();
								calendar1.setTime(itS.getTime());
								
								Calendar calendar2 = Calendar.getInstance();
								calendar2.setTime(itN.getTime());
								
								if (calendar1.getTime().equals(calendar2.getTime())) {
									
									N_dayinformationIterator.remove();		
									break;														
								}
							}
							
							SpecialSequencialVacationday.add(itS);
						}						
						SpecialSequencialVacationdayTemp.clear();									
					}
					else {
						SpecialSequencialVacationdayTemp.clear();
					}
				
			 }
			
		} 
		
		catch (java.util.ConcurrentModificationException e) {
			
			SeparateSequential_ThreeDay_Dayinformation();
		}
								
	}
	
	
	public void FindOneLocationIdentical(Approvel_N_Dayinformation location) throws CloneNotSupportedException {
		
		if (SpecialSequencialVacationdayTemp.isEmpty()) {
			Approvel_N_Dayinformation newtype = location.clone();
			
			
			if (newtype.getreasons().equals("请假")&&!newtype.getreasons_details().equals("换休")) {
				newtype.setWHETHERNEEDHIGHPASS(1);
				SpecialSequencialVacationdayTemp.add(newtype);
			}
			
		}
		else {			
			
				for (int j = 0; j < SpecialSequencialVacationdayTemp.size();j++) {
					
					if ( SpecialSequencialVacationdayTemp.get(j).getLabelday()!= location.getLabelday()) {	
						if (j==SpecialSequencialVacationdayTemp.size()-1) {
							
							Approvel_N_Dayinformation newtype = location.clone();
							if (newtype.getreasons().equals("请假")&&!newtype.getreasons_details().equals("换休")) {
								newtype.setWHETHERNEEDHIGHPASS(1);
								SpecialSequencialVacationdayTemp.add(newtype);
							}
						}
						continue;					
					}
					
					else if (SpecialSequencialVacationdayTemp.get(j).getLabelday() == location.getLabelday()) {						
						break;
					}
					
										
				}										
		}
		
        Iterator<Approvel_N_Dayinformation> iteratorN_dayinformation = N_dayinformation.iterator();
		
		while (iteratorN_dayinformation.hasNext()) {
						
			Approvel_N_Dayinformation itn = (Approvel_N_Dayinformation)iteratorN_dayinformation.next();
			
			Date nowtime =location.getTime();		   
			java.util.Date nowdateforuse = nowtime;
			   
			Date nowtime2 =itn.getTime();
			java.util.Date nowdateforuse2 = nowtime2;
					   				
			Calendar calendar1 = Calendar.getInstance();
		    calendar1.setTime(nowdateforuse);
			calendar1.set(Calendar.DAY_OF_MONTH, calendar1.get(Calendar.DAY_OF_MONTH)+1);
							   				  				   
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(nowdateforuse2);
				   
				   if (calendar1.getTime().equals(calendar2.getTime())) {
					   
					   Approvel_N_Dayinformation newtype = itn.clone();
						if (newtype.getreasons().equals("请假")&&!newtype.getreasons_details().equals("换休")) {
							newtype.setWHETHERNEEDHIGHPASS(1);
							SpecialSequencialVacationdayTemp.add(newtype);
						}
					   FindOneLocationIdentical(newtype);
					   break;
				   }
				   				   
			   }		   				
						
	      }
	
}
