package uitest1;

import java.util.Calendar;

public class mycalendar  {
	
	  //������ݺ��·� �·���1,calendar����ص�
	  int year=2005;
	  int month=1;
	  
      public void setYear(int year)   
      {   
          this.year=year;   
      }   
        
      public int getYear()   
      {   
          return year;   
      }   
        
      public void setMonth(int month)   
      {   
          this.month=month;   
      }   
        
      public int getMonth()   
      {   
          return month;   
      }   
      
      
      
      public String[] getCalendar()   
      {   
          String a[]=new String[42];   
          
          Calendar date=Calendar.getInstance();
          date.setFirstDayOfWeek(Calendar.MONDAY);
          date.set(year,month-1,1);   
          int week=date.get(Calendar.DAY_OF_WEEK);
          week = week+6;
          if (week>7) {        	  
        	  week = week-7;			
		   }
          week =week-1;               
          int day=0;              
          //�жϴ��·�  
          if(month==1||month==3||month==5||month==7 
            ||month==8||month==10||month==12)   
          {   
              day=31;   
          }   
            
          //�ж�С��  
          if(month==4||month==6||month==9||month==11)   
          {   
              day=30;   
          }   
            
          //�ж�ƽ��������  
          if(month==2)   
          {   
              if(((year%4==0)&&(year%100!=0))||(year%400==0))   
              {   
                  day=29;   
              }   
                
              else   
              {   
                  day=28;   
              }   
           }   
            
          for(int i=week,n=1;i<week+day;i++)   
          {   
                  a[i]=String.valueOf(n) ;   
                  n++;   
          } 
                    
          System.out.println("�ɹ�������һ���Զ�������");
          
          return a;   
       }  



}
