package testmain;

import java.util.ArrayList;
import java.util.Iterator;

import data.Dayinformation;
import data.Persondata;

public class test {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
			arrayList.add(1);
		
			Dayinformation goodday = new Dayinformation();
			Dayinformation badday = new Dayinformation();
			
			ArrayList list= new ArrayList();
			
			list.add(goodday);
			list.add(badday);
			
			
			Dayinformation goodday2 = new Dayinformation();
			Dayinformation badday2 = new Dayinformation();
			
			ArrayList list2= new ArrayList();
			
			list2.add(goodday2);
			list2.add(badday2);
			
			Persondata dPersondata = new Persondata(list);
			Persondata dPersondata2 = new Persondata(list2);
			
			ArrayList listddddArrayList= new ArrayList();
			
			listddddArrayList.add(dPersondata);
			listddddArrayList.add(dPersondata2);
			
			Iterator lIterator= listddddArrayList.iterator();
			
			while (lIterator.hasNext()) {

				
			}


		

			
			

		
	}

}
