package ojdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import tcp.ListInformation;
import user.User;
import vacation_extrawork.Approvel_N_Dayinformation;
import vacation_extrawork.OneManData;

public class LocaltestDataBaseOperation {
	
	
	Connection connect = null;
    Statement statement = null;
    ResultSet resultSet = null;
	
	
	public Connection LinkToDataBase() throws ClassNotFoundException, SQLException {
			
		connect = DriverManager.getConnection("jdbc:oracle:thin:@111.230.138.68:1521:VAChecking", "C##MY", "z456788002");		
        System.out.println(connect);         
        return connect;
               						
	}
	
	
	public void DisposeDataBaseLink() throws SQLException {
		
		if (statement!=null) {statement.close();}
		if (resultSet!=null) {resultSet.close();}
		if (connect!=null) {connect.close();}
		
	}
	
	
	public Connection LinkToLocalDataBase() throws ClassNotFoundException, SQLException {
		
		connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "C##MY", "z456788002");		
        System.out.println(connect);         
        return connect;
               						
	}
	
	public void DisposeLocalDataBaseLink() throws SQLException {
		
		if (statement!=null) {statement.close();}
		if (resultSet!=null) {resultSet.close();}
		if (connect!=null) {connect.close();}
		
	}
	
	public boolean InsertIntoOneLine_DATA_VACATIONANDOVERWORK(String name,int id,Date time,
			                                                  String ACTUALTIMENOCLEAR,String REASONS,
			                                                  String REASONS_DETAILS,String REASONS_EXPLANATION,String HANDLEOVERTIMEWORK) throws SQLException, ClassNotFoundException {
		
		LinkToLocalDataBase();
		
		if (connect!=null) {
			
			String sql = "INSERT INTO DATA_VACATIONANDOVERWORK (name,id,time,ACTUALTIMENOCLEAR,REASONS,REASONS_DETAILS,REASONS_EXPLANATION,HANDLEOVERTIMEWORK)VALUES(?,?,?,?,?,?,?,?)";
			
			PreparedStatement pre = connect.prepareStatement(sql);
			
			pre.setString(1,name);
			pre.setString(2,String.valueOf(id));
			pre.setDate(3, time);
			pre.setString(4,ACTUALTIMENOCLEAR);
			pre.setString(5,REASONS);
			pre.setString(6,REASONS_DETAILS);
			pre.setString(7,REASONS_EXPLANATION);
			pre.setString(8,HANDLEOVERTIMEWORK);
			
			pre.execute();			
			DisposeLocalDataBaseLink();									
			return true;
						
		}
		else {
			System.out.println("链接没有建立成功");
			DisposeLocalDataBaseLink();
			return false;
		}
			
	}
	
	public boolean DeleteOneLine_DATA_VACATIONANDOVERWORK(String name,int id,Date time,
            String ACTUALTIMENOCLEAR) throws SQLException, ClassNotFoundException {
		
		LinkToLocalDataBase();
		if (connect!=null) {
			
		String sql = "DELETE FROM DATA_VACATIONANDOVERWORK WHERE name = ?and ID =? and TIME = ? and ACTUALTIMENOCLEAR = ?";		
		PreparedStatement pre = connect.prepareStatement(sql);
		
		pre.setString(1, name);
		pre.setInt(2, id);
		pre.setDate(3,time);
		pre.setString(4, ACTUALTIMENOCLEAR);		
		int indexcount = pre.executeUpdate();	
		System.out.println(indexcount);
		
		 if (indexcount>0) {
			 DisposeLocalDataBaseLink();	
			return true;
				
		 }
		 else {
			 DisposeLocalDataBaseLink();	
			return false;
		 }
		}
		else {
			DisposeLocalDataBaseLink();	
			return false;
		}
			
	}
	
	public boolean InsertIntoOneLine_DATA_WOKERNAMELIST(int id,String name) throws SQLException, ClassNotFoundException {
		
		LinkToLocalDataBase();
		if (connect!=null) {
			
			String sql = "INSERT INTO WOKERNAMELIST (ID,NAME) VALUES (?,?)";		
			PreparedStatement pre = connect.prepareStatement(sql);			
			pre.setInt(1, id);
			pre.setString(2,name);				
			pre.execute();		
			DisposeLocalDataBaseLink();	
			return true;
									
		}
		else {
			System.out.println("链接没有建立成功");
			DisposeLocalDataBaseLink();	
			return false;
		}
		
	}
	
	public int GetID_from_Nanme(String name) throws ClassNotFoundException, SQLException {
		
		LinkToLocalDataBase();
		int id = -1;
		if (connect!=null) {
			
			String sql = "SELECT * FROM WOKERNAMELIST WHERE NAME = ?";
			PreparedStatement pre = connect.prepareStatement(sql);			
			pre.setString(1, name);		
			resultSet = pre.executeQuery();
			
			
			while (resultSet.next()) {
				
				id = resultSet.getInt("ID");
				
			}
						
		}
		DisposeLocalDataBaseLink();
		return id;
		
	}
	
	
	public void InsertInto_DATA_VACATIONANDOVERWORK_ONEMANDATAGROUP(ArrayList<OneManData> data) throws ClassNotFoundException, SQLException {
		
		LinkToLocalDataBase();
		
		if (connect!=null) {
			
			String onelineSQL = "INSERT INTO VACATION_APPROVAL (name,id,DEPARTMENT,LEVEL_SHAPE,time,ACTUALTIMENOCLEAR,REASONS,REASONS_DETAILS,REASONS_EXPLANATION,HANDLEOVERTIMEWORK,WHETHERNEEDHIGHPASS,VACATION_NORMAL_PASSED,VACATION_SPECIAL_PASSED,VA_AP_N_UPPER,VA_AP_H_UPPER)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pre = connect.prepareStatement(onelineSQL);					
			Iterator<OneManData> onemaniIterator = data.iterator();
			
			while (onemaniIterator.hasNext()) {
				OneManData dataforoneman = (OneManData)onemaniIterator.next();
				
				Iterator<Approvel_N_Dayinformation> dayinformationIterator = dataforoneman.getN_dayinformation().iterator();
				
				while (dayinformationIterator.hasNext()) {
					
					Approvel_N_Dayinformation datafordayinformaiton = (Approvel_N_Dayinformation)dayinformationIterator.next();

					pre.setString(1,dataforoneman.getName());
					pre.setString(2,String.valueOf(dataforoneman.getId()));
					pre.setString(3, datafordayinformaiton.getDEPARTMENT());
					pre.setString(4, datafordayinformaiton.getLEVEL_SHAPE());
					pre.setDate(5, datafordayinformaiton.getTime());
					pre.setString(6,datafordayinformaiton.getActualtimenoclear());
					pre.setString(7,datafordayinformaiton.getreasons());
					pre.setString(8,datafordayinformaiton.getreasons_details());
					pre.setString(9,datafordayinformaiton.getreasons_explanation());
					pre.setString(10,datafordayinformaiton.gethandleovertimework());
					pre.setInt(11,datafordayinformaiton.getWHETHERNEEDHIGHPASS());				
					pre.setInt(12, datafordayinformaiton.getVACATION_NORMAL_PASSED());
					pre.setInt(13, datafordayinformaiton.getVACATION_SPECIAL_PASSED());										
					pre.setString(14, datafordayinformaiton.getVACATION_APPROVAL_NORMAL_UPPER());
					pre.setString(15, datafordayinformaiton.getVACATION_APPROVAL_HIGHER_UPPER());
					
					pre.addBatch();
										
				}
				
	            Iterator<Approvel_N_Dayinformation> specialdayinformationIterator = dataforoneman.getSpecialSequencialVacationday().iterator();
				
				while (specialdayinformationIterator.hasNext()) {
					
					Approvel_N_Dayinformation datafordayinformaiton = (Approvel_N_Dayinformation)specialdayinformationIterator.next();

					pre.setString(1,dataforoneman.getName());
					pre.setString(2,String.valueOf(dataforoneman.getId()));
					pre.setString(3, datafordayinformaiton.getDEPARTMENT());
					pre.setString(4, datafordayinformaiton.getLEVEL_SHAPE());
					pre.setDate(5, datafordayinformaiton.getTime());
					pre.setString(6,datafordayinformaiton.getActualtimenoclear());
					pre.setString(7,datafordayinformaiton.getreasons());
					pre.setString(8,datafordayinformaiton.getreasons_details());
					pre.setString(9,datafordayinformaiton.getreasons_explanation());
					pre.setString(10,datafordayinformaiton.gethandleovertimework());
					pre.setInt(11,datafordayinformaiton.getWHETHERNEEDHIGHPASS());				
					pre.setInt(12, datafordayinformaiton.getVACATION_NORMAL_PASSED());
					pre.setInt(13, datafordayinformaiton.getVACATION_SPECIAL_PASSED());										
					pre.setString(14, datafordayinformaiton.getVACATION_APPROVAL_NORMAL_UPPER());
					pre.setString(15, datafordayinformaiton.getVACATION_APPROVAL_HIGHER_UPPER());
					
					pre.addBatch();
										
				}
				
			}
			int[] result = pre.executeBatch();
											
		}
		
		DisposeLocalDataBaseLink();
		
				
	}
	
	
	public ListInformation Selectfrom_DATA_VACATIONANDOVERWORK_Downloadchoose_ForOneName(String selectname,String []namelist,String reason,String reasondetail,Date[] period) throws ClassNotFoundException, SQLException {
		
		//已经设置好了分部门下载
        LinkToDataBase();
        
		if (connect!=null) {
			
			String sqlString ="select * from DATA_VACATIONANDOVERWORK where Time>= ? and Time<= ?";
			boolean allmodeactive = false;
			boolean reasonsset = false;
			boolean reasonsdetailset = false;
			
			
            if (selectname.equals("全部")) {
				
				String namelistsql = "";
				allmodeactive = true;
				sqlString+="and";
				for (int i = 0; i < namelist.length; i++) {
					
					if (i==0) {
						
						namelistsql +="name ="+"'"+namelist[i]+"'";
					}
					
					else {
						namelistsql +="or name ="+"'"+namelist[i]+"'";
					}				
										
				}
				
				sqlString = sqlString+"("+namelistsql+")";		
														
			}
			
			else {
				sqlString+="and name = ?";
			 }
						
			if (!reason.equals("全部")) {
				
				sqlString += "and reasons = ?";
				reasonsset = true;
			}
			
			if (!reasondetail.equals("全部")) {
				
				sqlString += "and REASONS_DETAILS = ?";
				reasonsdetailset = true;
			}
			
			
			PreparedStatement pre = connect.prepareStatement(sqlString);
			ParameterMetaData parameterMetaData = null;
			parameterMetaData = pre.getParameterMetaData();
			int count = parameterMetaData.getParameterCount();
			System.out.println(count);
			
			//可能性只有一种 就是全部选出来
			if (count ==2) {
				
				System.out.println(sqlString);
				pre.setDate(1, GetTheSmallerTimeInperiod(period));
				pre.setDate(2, GetTheBiggerTimeInperiod(period));
				
				ResultSet myresultSet = pre.executeQuery();
				if (!myresultSet.isBeforeFirst()) {
					
					ShowDialog("选定的范围内没有数据");
					return null;
				}
				
				ListInformation informationgroup = new ListInformation();
				while (myresultSet.next()) {
					
				String NAME = myresultSet.getString("NAME");
				int IDint = myresultSet.getInt("ID");
				String ID= String.valueOf(IDint);
				Date TIMEdate = myresultSet.getDate("TIME");
				String Time = String.valueOf(TIMEdate);
				String ACTUALTIMENOCLEAR = myresultSet.getString("ACTUALTIMENOCLEAR");
				String REASONS = myresultSet.getString("REASONS");
				String REASONS_DETAILS = myresultSet.getString("REASONS_DETAILS");
				String REASONS_EXPLANATION = myresultSet.getString("REASONS_EXPLANATION");
				String HANDLEOVERTIMEWORK = myresultSet.getString("HANDLEOVERTIMEWORK");
				
				ArrayList<String> datagroup = new ArrayList<String>();
				datagroup.add(NAME);
				datagroup.add(ID);
				datagroup.add(Time);
				datagroup.add(ACTUALTIMENOCLEAR);
				datagroup.add(REASONS);
				datagroup.add(REASONS_DETAILS);
				datagroup.add(REASONS_EXPLANATION);
				datagroup.add(HANDLEOVERTIMEWORK);
								
				informationgroup.getLineinformationgroup().add(datagroup);
				
				}
				DisposeLocalDataBaseLink();
				return informationgroup;
				
			}
			
			
			
			//有两种可能性，如果是非全部选出来只有一种肯可能性，就是单个选人，否则就是全部选出来
			  
			if (count == 3) {
				
				pre.setDate(1, GetTheSmallerTimeInperiod(period));
				pre.setDate(2, GetTheBiggerTimeInperiod(period));
				
				if (allmodeactive == false) {
					pre.setString(3, selectname);
				}
				
				else {
					
					if (reasonsset == true) {
						
						pre.setString(3, reason);
					}
					
					if (reasonsdetailset == true) {
						
						pre.setString(3, reasondetail);
					}
					
				}
				
				
				ResultSet myresultSet = pre.executeQuery();
				if (!myresultSet.isBeforeFirst()) {
					
					ShowDialog("选定的范围内没有数据");
					return null;
				}
				
				ListInformation informationgroup = new ListInformation();
				while (myresultSet.next()) {
					
				String NAME = myresultSet.getString("NAME");
				int IDint = myresultSet.getInt("ID");
				String ID= String.valueOf(IDint);
				Date TIMEdate = myresultSet.getDate("TIME");
				String Time = String.valueOf(TIMEdate);
				String ACTUALTIMENOCLEAR = myresultSet.getString("ACTUALTIMENOCLEAR");
				String REASONS = myresultSet.getString("REASONS");
				String REASONS_DETAILS = myresultSet.getString("REASONS_DETAILS");
				String REASONS_EXPLANATION = myresultSet.getString("REASONS_EXPLANATION");
				String HANDLEOVERTIMEWORK = myresultSet.getString("HANDLEOVERTIMEWORK");
				
				ArrayList<String> datagroup = new ArrayList<String>();
				datagroup.add(NAME);
				datagroup.add(ID);
				datagroup.add(Time);
				datagroup.add(ACTUALTIMENOCLEAR);
				datagroup.add(REASONS);
				datagroup.add(REASONS_DETAILS);
				datagroup.add(REASONS_EXPLANATION);
				datagroup.add(HANDLEOVERTIMEWORK);
								
				informationgroup.getLineinformationgroup().add(datagroup);
				
				}
				DisposeLocalDataBaseLink();
				return informationgroup;
			}
			
			
			if (count == 4) {
				
				
				pre.setDate(1, GetTheSmallerTimeInperiod(period));
				pre.setDate(2, GetTheBiggerTimeInperiod(period));
				
				if (allmodeactive == false) {
					
					if (reasonsset == true) {
						
						pre.setString(3, selectname);
						pre.setString(4, reason);
					}
					
					if (reasonsdetailset == true) {
						pre.setString(3, selectname);
						pre.setString(4, reasondetail);
					}
					
					
				}
				else {					
					pre.setString(3, reason);
					pre.setString(4, reasondetail);					
				}
								
				
				ResultSet myresultSet = pre.executeQuery();
				if (!myresultSet.isBeforeFirst()) {
					
					ShowDialog("选定的范围内没有数据");
					return null;
				}
				
				ListInformation informationgroup = new ListInformation();
				while (myresultSet.next()) {
				String NAME = myresultSet.getString("NAME");
				int IDint = myresultSet.getInt("ID");
				String ID= String.valueOf(IDint);
				Date TIMEdate = myresultSet.getDate("TIME");
				String Time = String.valueOf(TIMEdate);
				String ACTUALTIMENOCLEAR = myresultSet.getString("ACTUALTIMENOCLEAR");
				String REASONS = myresultSet.getString("REASONS");
				String REASONS_DETAILS = myresultSet.getString("REASONS_DETAILS");
				String REASONS_EXPLANATION = myresultSet.getString("REASONS_EXPLANATION");
				String HANDLEOVERTIMEWORK = myresultSet.getString("HANDLEOVERTIMEWORK");
				
				ArrayList<String> datagroup = new ArrayList<String>();
				datagroup.add(NAME);
				datagroup.add(ID);
				datagroup.add(Time);
				datagroup.add(ACTUALTIMENOCLEAR);
				datagroup.add(REASONS);
				datagroup.add(REASONS_DETAILS);
				datagroup.add(REASONS_EXPLANATION);
				datagroup.add(HANDLEOVERTIMEWORK);
								
				informationgroup.getLineinformationgroup().add(datagroup);
				
				}
				DisposeLocalDataBaseLink();
				return informationgroup;
				
			}
			
	        if (count == 5) {
				
				
				pre.setDate(1, GetTheSmallerTimeInperiod(period));
				pre.setDate(2, GetTheBiggerTimeInperiod(period));
				pre.setString(3, selectname);
				pre.setString(4, reason);
				pre.setString(5, reasondetail);
				
				ResultSet myresultSet = pre.executeQuery();
				if (!myresultSet.isBeforeFirst()) {
					
					ShowDialog("选定的范围内没有数据");
					return null;
				}
				
				ListInformation informationgroup = new ListInformation();
				while (myresultSet.next()) {
				String NAME = myresultSet.getString("NAME");
				int IDint = myresultSet.getInt("ID");
				String ID= String.valueOf(IDint);
				Date TIMEdate = myresultSet.getDate("TIME");
				String Time = String.valueOf(TIMEdate);
				String ACTUALTIMENOCLEAR = myresultSet.getString("ACTUALTIMENOCLEAR");
				String REASONS = myresultSet.getString("REASONS");
				String REASONS_DETAILS = myresultSet.getString("REASONS_DETAILS");
				String REASONS_EXPLANATION = myresultSet.getString("REASONS_EXPLANATION");
				String HANDLEOVERTIMEWORK = myresultSet.getString("HANDLEOVERTIMEWORK");
				
				ArrayList<String> datagroup = new ArrayList<String>();
				datagroup.add(NAME);
				datagroup.add(ID);
				datagroup.add(Time);
				datagroup.add(ACTUALTIMENOCLEAR);
				datagroup.add(REASONS);
				datagroup.add(REASONS_DETAILS);
				datagroup.add(REASONS_EXPLANATION);
				datagroup.add(HANDLEOVERTIMEWORK);
								
				informationgroup.getLineinformationgroup().add(datagroup);
				
				}
				DisposeLocalDataBaseLink();
				return informationgroup;
				
			}
			ShowDialog("程序出错联系管理员");
			return null;
		}
		DisposeDataBaseLink();
		
		return null;
				
	}
	
	public boolean InsertIntoOneLine_DATA_ACCOUNT(String username,String password,String workname,String email) throws ClassNotFoundException, SQLException {
		
	       LinkToLocalDataBase();
	       
			int id = -1;
			String duty = null;
			String department = null;
			String level_shape = null;
			int power_level = -1;
			int whethermanager =-1;
			
			int VA_AP_N_RIGHT= -1;
			int VA_AP_H_RIGHT = -1;
			int AS_AP_N_RIGHT = -1;
			int AS_AP_H_RIGHT = -1;
			
			String VA_AP_N_UPPER= null;
			String VA_AP_H_UPPER= null;
			String AS_AP_N_UPPER= null;
			String AS_AP_H_UPPER= null;
			
			if (connect!=null) {
				
				//根据员工表检查信息
				
				String sqlcheck = "SELECT * FROM WOKERNAMELIST WHERE NAME = ?";
				PreparedStatement precheck = connect.prepareStatement(sqlcheck);			
				precheck.setString(1, workname);		
				ResultSet resultSetcheck = precheck.executeQuery();
				
				
				if (!resultSetcheck .isBeforeFirst()) {
					
					ShowDialog("员工表中没有你的姓名，请联系管理员");
					return false;
				}
				

				while (resultSetcheck.next()) {
					
					id = resultSetcheck.getInt("ID");
					duty = resultSetcheck.getString("duty");
					department = resultSetcheck.getString("department");
					level_shape = resultSetcheck.getString("level_shape");
					
				}
				
				//取出power-level和whethermanager
							
				String sqlgetpower = "SELECT * FROM DUTYLIST WHERE duty =? ";
				PreparedStatement pregetpower = connect.prepareStatement(sqlgetpower);			
				pregetpower.setString(1, duty);		
				ResultSet resultgetpower =pregetpower.executeQuery();
				
				
				if (!resultgetpower .isBeforeFirst()) {
					
					ShowDialog("在dutylist表中不能查找到该duty，联系管理员");
					return false;
				}
				
				while (resultgetpower.next()) {
					
					power_level = resultgetpower.getInt("power_level");
					whethermanager = resultgetpower.getInt("whethermanager");
										
				}
				
				//从MANAGER_RELATIONSHIP取出vacation和assess权限
				
				

				String sqlgetvacationassess = "SELECT * FROM ADMI_MANAGER WHERE WOKER_NAME = ?";
				PreparedStatement pregetvacationassess = connect.prepareStatement(sqlgetvacationassess);			
				pregetvacationassess.setString(1, workname);		
				ResultSet resultgetvacationasses =pregetvacationassess.executeQuery();
				
				
				if (!resultgetvacationasses.isBeforeFirst()) {
					//如果找不到					
					
				}
				
				while (resultgetvacationasses.next()) {
					
					VA_AP_N_UPPER = resultgetvacationasses.getString("VA_AP_N_UPPER");
					VA_AP_H_UPPER = resultgetvacationasses.getString("VA_AP_H_UPPER");
					AS_AP_N_UPPER = resultgetvacationasses.getString("AS_AP_N_UPPER");
					AS_AP_H_UPPER = resultgetvacationasses.getString("AS_AP_H_UPPER");
					VA_AP_N_RIGHT = resultgetvacationasses.getInt("VA_AP_N_RIGHT");
					VA_AP_H_RIGHT = resultgetvacationasses.getInt("VA_AP_H_RIGHT");
					AS_AP_N_RIGHT = resultgetvacationasses.getInt("AS_AP_N_RIGHT");
					AS_AP_H_RIGHT = resultgetvacationasses.getInt("AS_AP_H_RIGHT");
										
				}
				
								
				//尝试插入帐号
														
				String insertaccountsql = "INSERT INTO ACCOUNT (username,password,WOKERNAME,id,DEPARTMENT,duty,power_level,whethermanager,level_shape,VA_AP_N_UPPER,VA_AP_H_UPPER,AS_AP_N_UPPER,AS_AP_H_UPPER,email,VA_AP_N_RIGHT,VA_AP_H_RIGHT,AS_AP_N_RIGHT,AS_AP_H_RIGHT)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preinsertaccount = connect.prepareStatement(insertaccountsql);
				
				preinsertaccount.setString(1, username);
				preinsertaccount.setString(2, password);
				preinsertaccount.setString(3, workname);
				preinsertaccount.setInt(4, id);
				preinsertaccount.setString(5, department);
				preinsertaccount.setString(6, duty);
				preinsertaccount.setInt(7, power_level);
				preinsertaccount.setInt(8, whethermanager);
				preinsertaccount.setString(9, level_shape);
				preinsertaccount.setString(10, VA_AP_N_UPPER);
				preinsertaccount.setString(11, VA_AP_H_UPPER);
				preinsertaccount.setString(12, AS_AP_N_UPPER );
				preinsertaccount.setString(13, AS_AP_H_UPPER);
				preinsertaccount.setString(14, email);
				preinsertaccount.setInt(15, VA_AP_N_RIGHT);
				preinsertaccount.setInt(16, VA_AP_H_RIGHT);
				preinsertaccount.setInt(17, AS_AP_N_RIGHT);
				preinsertaccount.setInt(18, AS_AP_H_RIGHT);
								
				int result = preinsertaccount.executeUpdate();
				
				
				if (result == 0) {
					
					return false;
					
				}
				
				if (result == 1) {
					
					return true;
					
				}
							
			}
			
			DisposeLocalDataBaseLink();			
			return false;		
	}
	
	public Map<ArrayList<String>, String> SelectOneLine_DATA_ACCOUNT(String username,String password) throws ClassNotFoundException, SQLException
	{
		LinkToLocalDataBase();
		
		if (connect!=null) {
			
			String SelectSQL = "SELECT * FROM account";
			PreparedStatement pre = connect.prepareStatement(SelectSQL);
			ResultSet myresultSet = pre.executeQuery();
			
			if (!myresultSet.isBeforeFirst()) {
				
				Map<ArrayList<String>, String> resutMap = new HashMap<ArrayList<String>, String>();
				resutMap.put(new ArrayList<String>(), "数据库中没有读取到任何帐号数据，请联系管理员");	
				DisposeLocalDataBaseLink();
				return resutMap;
				
			}
			
			while (myresultSet.next()) {
				
				String usenameString= myresultSet.getString("Username");				
				String passwordString= myresultSet.getString("password");
				String wokernameString= myresultSet.getString("WOKERNAME");
				String idString= myresultSet.getString("id");
				String departmentString= myresultSet.getString("DEPARTMENT");
				String duty = myresultSet.getString("DUTY");
				String power_level = myresultSet.getString("POWER_LEVEL");
				String whether_manager = myresultSet.getString("WHETHERMANAGER");
				String level_shape = myresultSet.getString("LEVEL_SHAPE");
				String VACATION_APPROVAL_NORMAL_UPPER = myresultSet.getString("VA_AP_N_UPPER");
				String VACATION_APPROVAL_HIGHER_UPPER = myresultSet.getString("VA_AP_H_UPPER");
				String ASSESS_APPROVAL_NORMAL_UPPER = myresultSet.getString("AS_AP_N_UPPER");
				String ASSESS_APPROVAL_HIGHER_UPPER = myresultSet.getString("AS_AP_H_UPPER");
				String email = myresultSet.getString("email");
				String VACATION_APPROVAL_NORMAL_RIGHT = myresultSet.getString("VA_AP_N_RIGHT");
				String VACATION_APPROVAL_HIGHER_RIGHT = myresultSet.getString("VA_AP_H_RIGHT");
				String ASSESS_APPROVAL_NORMAL_RIGHT = myresultSet.getString("AS_AP_N_RIGHT");
				String ASSESS_APPROVAL_HIGHER_RIGHT = myresultSet.getString("AS_AP_H_RIGHT");
												
				if (usenameString.equals(username)) {
					
					if (passwordString.equals(password)) {
						
						Map<ArrayList<String>, String> resutMap = new HashMap<ArrayList<String>, String>();
						ArrayList<String> userinformationArrayList  = new ArrayList<String>();
						userinformationArrayList.add(wokernameString);
						userinformationArrayList.add(usenameString);
						userinformationArrayList.add(passwordString);
						userinformationArrayList.add(idString);
						userinformationArrayList.add(departmentString);
						userinformationArrayList.add(duty);
						userinformationArrayList.add(power_level);
						userinformationArrayList.add(whether_manager);
						userinformationArrayList.add(level_shape);
						userinformationArrayList.add(VACATION_APPROVAL_NORMAL_UPPER);
						userinformationArrayList.add(VACATION_APPROVAL_HIGHER_UPPER);
						userinformationArrayList.add(ASSESS_APPROVAL_NORMAL_UPPER);
						userinformationArrayList.add(ASSESS_APPROVAL_HIGHER_UPPER);
						userinformationArrayList.add(email);
						userinformationArrayList.add(VACATION_APPROVAL_NORMAL_RIGHT);
						userinformationArrayList.add(VACATION_APPROVAL_HIGHER_RIGHT);
						userinformationArrayList.add(ASSESS_APPROVAL_NORMAL_RIGHT);
						userinformationArrayList.add(ASSESS_APPROVAL_HIGHER_RIGHT);
						resutMap.put(userinformationArrayList, "成功登录");						
						DisposeLocalDataBaseLink();
						return resutMap;
					}
				}
				
			}
			
			Map<ArrayList<String>, String> resutMap = new HashMap<ArrayList<String>, String>();
			resutMap.put(new ArrayList<String>(), "帐号或者密码错误");
			DisposeLocalDataBaseLink();
			return resutMap;
									
		}
		
		Map<ArrayList<String>, String> resutMap = new HashMap<ArrayList<String>, String>();
		resutMap.put(new ArrayList<String>(), "数据库连接错误");		
		DisposeLocalDataBaseLink();
		return resutMap;
		
	}
	
	public ArrayList<ListInformation> Selectfrom_DATA_VACATION_WORK_APPROVAL_ForUser(User user) throws ClassNotFoundException, SQLException {
		
       LinkToLocalDataBase();
		
		if (connect!=null) {
						
			int VACATION_APPROVAL_NORMAL = Integer.valueOf(user.getVACATION_APPROVAL_NORMAL_RIGHT());
			int VACATION_APPROVAL_HIGHER = Integer.valueOf(user.getVACATION_APPROVAL_HIGHER_RIGHT());
			String level_shape = user.getLevel_shape();
			ListInformation informationgroup_doublerightsameperson = new ListInformation();
			ListInformation informationgroup_onlynormalright = new ListInformation();
			ListInformation informationgroup_onlyhighright = new ListInformation();
			ArrayList<ListInformation> vacationapprovalinfomationArrayList = new ArrayList<ListInformation>();

			//同时具有两个权限的情况下			
			if (VACATION_APPROVAL_NORMAL ==1 && VACATION_APPROVAL_HIGHER==1 ) {
				
			    //选出两个审批人都是同一个的情况，插入一个标记数据
				String SelectSQL_doublerightsameperson = "SELECT * FROM VACATION_APPROVAL WHERE VA_AP_N_UPPER = ? and VA_AP_H_UPPER = ? and VACATION_NORMAL_PASSED = 0 and VACATION_SPECIAL_PASSED =0";
						
				PreparedStatement pre_doublerightsameperson = connect.prepareStatement(SelectSQL_doublerightsameperson);
				pre_doublerightsameperson.setString(1, user.getCheckname());
				pre_doublerightsameperson.setString(2, user.getCheckname());
				System.out.println(SelectSQL_doublerightsameperson);
				
				ResultSet myresultSet_doublerightsameperson = pre_doublerightsameperson.executeQuery();				               
                
				
                while (myresultSet_doublerightsameperson.next()) {
					
                	String NAME = myresultSet_doublerightsameperson.getString("NAME");
                	Date time = myresultSet_doublerightsameperson.getDate("time");
                	String timeString = time.toString();
                	String ACTUALTIMENOCLEAR = myresultSet_doublerightsameperson.getString("ACTUALTIMENOCLEAR");
                	String REASONS_DETAILS = myresultSet_doublerightsameperson.getString("REASONS_DETAILS");
                	String DEPARTMENT= myresultSet_doublerightsameperson.getString("DEPARTMENT");
                	String REASONS_EXPLANATION = myresultSet_doublerightsameperson.getString("REASONS_EXPLANATION");
                	
                	ArrayList<String> arrayList = new ArrayList<String>();
                	
                	arrayList.add(NAME);
                	arrayList.add(timeString);
                	arrayList.add(ACTUALTIMENOCLEAR);
                	arrayList.add(REASONS_DETAILS);
                	arrayList.add(DEPARTMENT);
                	arrayList.add(REASONS_EXPLANATION);
                	           	
                	informationgroup_doublerightsameperson.getLineinformationgroup().add(arrayList);
                						
				}
                
                
                //选出单独一个审批人是普通请假的情况，插入一个标记的数据。
            	String SelectSQL_onlynormalright = "SELECT * FROM VACATION_APPROVAL WHERE VA_AP_N_UPPER = ? and VA_AP_H_UPPER != ? and VACATION_NORMAL_PASSED = 0";
				
				PreparedStatement pre_onlynormalright = connect.prepareStatement(SelectSQL_onlynormalright);
				pre_onlynormalright.setString(1, user.getCheckname());
				pre_onlynormalright.setString(2, user.getCheckname());
				System.out.println(SelectSQL_onlynormalright);
				
				ResultSet myresultSet_onlynormalright = pre_onlynormalright.executeQuery();				               
                
                while (myresultSet_onlynormalright.next()) {
					
                	String NAME = myresultSet_onlynormalright.getString("NAME");
                	Date time = myresultSet_onlynormalright.getDate("time");
                	String timeString = time.toString();
                	String ACTUALTIMENOCLEAR = myresultSet_onlynormalright.getString("ACTUALTIMENOCLEAR");
                	String REASONS_DETAILS = myresultSet_onlynormalright.getString("REASONS_DETAILS");
                	String DEPARTMENT= myresultSet_onlynormalright.getString("DEPARTMENT");
                	String REASONS_EXPLANATION = myresultSet_onlynormalright.getString("REASONS_EXPLANATION");
                	
                	ArrayList<String> arrayList = new ArrayList<String>();
                	
                	arrayList.add(NAME);
                	arrayList.add(timeString);
                	arrayList.add(ACTUALTIMENOCLEAR);
                	arrayList.add(REASONS_DETAILS);
                	arrayList.add(DEPARTMENT);
                	arrayList.add(REASONS_EXPLANATION);
                	           	
                	informationgroup_onlynormalright.getLineinformationgroup().add(arrayList);
                						
				}
                
                
                //选出单独一个审批人是高级请假的情况，插入一个标记数据
                String SelectSQL_onlyhighright = "SELECT * FROM VACATION_APPROVAL WHERE VA_AP_N_UPPER != ? and VA_AP_H_UPPER = ? and VACATION_NORMAL_PASSED = 1 and VACATION_SPECIAL_PASSED =0 and WHETHERNEEDHIGHPASS = 1";
				
				PreparedStatement pre__onlyhighright = connect.prepareStatement(SelectSQL_onlyhighright);
				pre__onlyhighright.setString(1, user.getCheckname());
				pre__onlyhighright.setString(2, user.getCheckname());
				System.out.println(SelectSQL_onlyhighright);
				
				ResultSet myresultSet_onlyhighright = pre__onlyhighright.executeQuery();				               
                
                while (myresultSet_onlyhighright.next()) {
					
                	String NAME = myresultSet_onlyhighright.getString("NAME");
                	Date time = myresultSet_onlyhighright.getDate("time");
                	String timeString = time.toString();
                	String ACTUALTIMENOCLEAR = myresultSet_onlyhighright.getString("ACTUALTIMENOCLEAR");
                	String REASONS_DETAILS = myresultSet_onlyhighright.getString("REASONS_DETAILS");
                	String DEPARTMENT= myresultSet_onlyhighright.getString("DEPARTMENT");
                	String REASONS_EXPLANATION = myresultSet_onlyhighright.getString("REASONS_EXPLANATION");
                	
                	ArrayList<String> arrayList = new ArrayList<String>();
                	
                	arrayList.add(NAME);
                	arrayList.add(timeString);
                	arrayList.add(ACTUALTIMENOCLEAR);
                	arrayList.add(REASONS_DETAILS);
                	arrayList.add(DEPARTMENT);
                	arrayList.add(REASONS_EXPLANATION);
                	           	
                	informationgroup_onlyhighright.getLineinformationgroup().add(arrayList);
                						
				}
                

				
			}
			
			//审批人只具有单普通审批权限			
			if (VACATION_APPROVAL_NORMAL ==1 && VACATION_APPROVAL_HIGHER  == 0) {
							
				//选出单独一个审批人是普通请假的情况，插入一个标记的数据。
            	String SelectSQL_onlynormalright = "SELECT * FROM VACATION_APPROVAL WHERE VA_AP_N_UPPER = ? and VA_AP_H_UPPER != ? and VACATION_NORMAL_PASSED = 0";
				
				PreparedStatement pre_onlynormalright = connect.prepareStatement(SelectSQL_onlynormalright);
				pre_onlynormalright.setString(1, user.getCheckname());
				pre_onlynormalright.setString(2, user.getCheckname());
				System.out.println(SelectSQL_onlynormalright);
				
				ResultSet myresultSet_onlynormalright = pre_onlynormalright.executeQuery();				               
                
                while (myresultSet_onlynormalright.next()) {
					
                	String NAME = myresultSet_onlynormalright.getString("NAME");
                	Date time = myresultSet_onlynormalright.getDate("time");
                	String timeString = time.toString();
                	String ACTUALTIMENOCLEAR = myresultSet_onlynormalright.getString("ACTUALTIMENOCLEAR");
                	String REASONS_DETAILS = myresultSet_onlynormalright.getString("REASONS_DETAILS");
                	String DEPARTMENT= myresultSet_onlynormalright.getString("DEPARTMENT");
                	String REASONS_EXPLANATION = myresultSet_onlynormalright.getString("REASONS_EXPLANATION");
                	
                	ArrayList<String> arrayList = new ArrayList<String>();
                	
                	arrayList.add(NAME);
                	arrayList.add(timeString);
                	arrayList.add(ACTUALTIMENOCLEAR);
                	arrayList.add(REASONS_DETAILS);
                	arrayList.add(DEPARTMENT);
                	arrayList.add(REASONS_EXPLANATION);
                	           	
                	informationgroup_onlynormalright.getLineinformationgroup().add(arrayList);
                						
				}
								
			}
			
			if (VACATION_APPROVAL_NORMAL ==0 && VACATION_APPROVAL_HIGHER  == 1) 
			{
				
				 //选出单独一个审批人是高级请假的情况，插入一个标记数据
                String SelectSQL_onlyhighright = "SELECT * FROM VACATION_APPROVAL WHERE VA_AP_N_UPPER != ? and VA_AP_H_UPPER = ? and VACATION_NORMAL_PASSED = 1 and VACATION_SPECIAL_PASSED =0 and WHETHERNEEDHIGHPASS = 1";
				
				PreparedStatement pre__onlyhighright = connect.prepareStatement(SelectSQL_onlyhighright);
				pre__onlyhighright.setString(1, user.getCheckname());
				pre__onlyhighright.setString(2, user.getCheckname());
				System.out.println(SelectSQL_onlyhighright);
				
				ResultSet myresultSet_onlyhighright = pre__onlyhighright.executeQuery();				               
                
                while (myresultSet_onlyhighright.next()) {
					
                	String NAME = myresultSet_onlyhighright.getString("NAME");
                	Date time = myresultSet_onlyhighright.getDate("time");
                	String timeString = time.toString();
                	String ACTUALTIMENOCLEAR = myresultSet_onlyhighright.getString("ACTUALTIMENOCLEAR");
                	String REASONS_DETAILS = myresultSet_onlyhighright.getString("REASONS_DETAILS");
                	String DEPARTMENT= myresultSet_onlyhighright.getString("DEPARTMENT");
                	String REASONS_EXPLANATION = myresultSet_onlyhighright.getString("REASONS_EXPLANATION");
                	
                	ArrayList<String> arrayList = new ArrayList<String>();
                	
                	arrayList.add(NAME);
                	arrayList.add(timeString);
                	arrayList.add(ACTUALTIMENOCLEAR);
                	arrayList.add(REASONS_DETAILS);
                	arrayList.add(DEPARTMENT);
                	arrayList.add(REASONS_EXPLANATION);
                	           	
                	informationgroup_onlyhighright.getLineinformationgroup().add(arrayList);
                						
				}
				
			}
			
			DisposeLocalDataBaseLink();
			
			vacationapprovalinfomationArrayList.add(informationgroup_onlynormalright);
			vacationapprovalinfomationArrayList.add(informationgroup_onlyhighright);
			vacationapprovalinfomationArrayList.add(informationgroup_doublerightsameperson);
			
			if (informationgroup_doublerightsameperson.getLineinformationgroup().isEmpty()&&informationgroup_onlyhighright.getLineinformationgroup().isEmpty()&&informationgroup_onlynormalright.getLineinformationgroup().isEmpty()) {
				
				ShowDialog("暂时没有读取到需要审批的数据");
				return null;
				
			}
						
			return vacationapprovalinfomationArrayList;
					
			
		}
		
		DisposeLocalDataBaseLink();
		return null;
		
	}
	
	
	public void Update_VACATION_WORK_NORMOL_APPROVAL_state(ListInformation datagroup_singlenormal,ListInformation datagroup_singlespecial,ListInformation datagroup_doubleright) throws SQLException, ClassNotFoundException {
		
		  LinkToLocalDataBase();
			
			if (connect!=null) {
				
				connect.setAutoCommit(false);
				//更新表单请假状态记号,singnormal审批
				if (!datagroup_singlenormal.getLineinformationgroup().isEmpty()) {
					
					String SQL_singlenormal = "UPDATE VACATION_APPROVAL SET VACATION_NORMAL_PASSED = 1 WHERE name = ? and ACTUALTIMENOCLEAR = ? and to_char(time,'yyyy-mm-dd')=? ";		
					PreparedStatement pre_singlenormal = connect.prepareStatement(SQL_singlenormal);
					
					
					for (ArrayList<String> data : datagroup_singlenormal.getLineinformationgroup()) {
						
						pre_singlenormal.setString(1, data.get(0));
						pre_singlenormal.setString(2, data.get(1));
						pre_singlenormal.setString(3, data.get(2));					
						pre_singlenormal.addBatch();
						
					}
					
					int[] myresultSet_singlenormal = pre_singlenormal.executeBatch();
				}

							
				//更新表单请假状态记号,singlespecial审批
				
				if (!datagroup_singlespecial.getLineinformationgroup().isEmpty()) {
								
				String SQL_singlespecial = "UPDATE VACATION_APPROVAL SET VACATION_SPECIAL_PASSED = 1 WHERE name = ? and ACTUALTIMENOCLEAR = ? and to_char(time,'yyyy-mm-dd')=? ";		
				PreparedStatement pre_singlespecial = connect.prepareStatement(SQL_singlespecial);
				
				
				for (ArrayList<String> data : datagroup_singlespecial.getLineinformationgroup()) {
					
					pre_singlespecial.setString(1, data.get(0));
					pre_singlespecial.setString(2, data.get(1));
					pre_singlespecial.setString(3, data.get(2));					
					pre_singlespecial.addBatch();
					
				}
				
				int[] myresultSet_singlespecial = pre_singlespecial.executeBatch();
				
				}
				
				//更新表单请假状态记号,doubleright审批
				if (!datagroup_doubleright.getLineinformationgroup().isEmpty()) {
					
				String SQL_doubleright = "UPDATE VACATION_APPROVAL SET VACATION_SPECIAL_PASSED = 1,VACATION_NORMAL_PASSED = 1 WHERE name = ? and ACTUALTIMENOCLEAR = ? and to_char(time,'yyyy-mm-dd')=? ";		
				PreparedStatement pre_doubleright = connect.prepareStatement(SQL_doubleright);
				
				
				for (ArrayList<String> data : datagroup_doubleright.getLineinformationgroup()) {
					
					pre_doubleright.setString(1, data.get(0));
					pre_doubleright.setString(2, data.get(1));
					pre_doubleright.setString(3, data.get(2));					
					pre_doubleright.addBatch();
					
				}
				
				int[] myresultSet_doubleright = pre_doubleright.executeBatch();
				
				}		
				
				//转移数据1 不需要高级审批的数据
				
				String SQL1 = "insert into DATA_VACATIONANDOVERWORK(name,id,time,ACTUALTIMENOCLEAR,REASONS,REASONS_DETAILS,REASONS_EXPLANATION,HANDLEOVERTIMEWORK) select name, id ,time ,ACTUALTIMENOCLEAR, REASONS, REASONS_DETAILS,REASONS_EXPLANATION,HANDLEOVERTIMEWORK from VACATION_APPROVAL where VACATION_NORMAL_PASSED = 1 and WHETHERNEEDHIGHPASS = 0";	
				PreparedStatement pre1 = connect.prepareStatement(SQL1);
				pre1.executeUpdate();
				
				
				
				//转移数据2 需要高级审批的数据
				
				String SQL2 = "insert into DATA_VACATIONANDOVERWORK(name,id,time,ACTUALTIMENOCLEAR,REASONS,REASONS_DETAILS,REASONS_EXPLANATION,HANDLEOVERTIMEWORK) select name, id ,time ,ACTUALTIMENOCLEAR, REASONS, REASONS_DETAILS,REASONS_EXPLANATION,HANDLEOVERTIMEWORK from VACATION_APPROVAL where VACATION_NORMAL_PASSED = 1 and VACATION_SPECIAL_PASSED = 1 and WHETHERNEEDHIGHPASS = 1";	
				PreparedStatement pre2 = connect.prepareStatement(SQL2);
				pre2.executeUpdate();
				 
				//删除原数据1
				String SQL3 = "DELETE FROM VACATION_APPROVAL WHERE VACATION_NORMAL_PASSED  = 1 and WHETHERNEEDHIGHPASS = 0";	
				PreparedStatement pre3 = connect.prepareStatement(SQL3);
				pre3.executeUpdate();
				
				//删除原数据2
				String SQL4 = "DELETE FROM VACATION_APPROVAL WHERE VACATION_NORMAL_PASSED  = 1 and VACATION_SPECIAL_PASSED = 1 and WHETHERNEEDHIGHPASS = 1";	
				PreparedStatement pre4 = connect.prepareStatement(SQL4);
				pre4.executeUpdate();
				
				connect.commit();
				
				ShowDialog("审批提交成功");
				
				
			}
		
		DisposeLocalDataBaseLink();
		
	}
	
	public void Delete_VACATION_WORK_NORMOL_APPROVAL(ListInformation datagroup) throws SQLException, ClassNotFoundException {
	
	
		LinkToLocalDataBase();
		if (connect!=null) {
			
			String SQLdelete = "DELETE FROM VACATION_APPROVAL WHERE name = ? and ACTUALTIMENOCLEAR = ? and to_char(time,'yyyy-mm-dd')=?";		
			PreparedStatement pre = connect.prepareStatement(SQLdelete);
			
			
			for (ArrayList<String> data : datagroup.getLineinformationgroup()) {
				
				pre.setString(1, data.get(0));
				pre.setString(2, data.get(1));
				pre.setString(3, data.get(2));					
				pre.addBatch();
				
			}
			
			int[] myresultSet = pre.executeBatch();
			
			
		}
		DisposeLocalDataBaseLink();
		
	
	}
	
	public ArrayList<String> SelectDownLoadlist_From_DataBase(User user) throws ClassNotFoundException, SQLException {
		

		LinkToLocalDataBase();
		if (connect!=null) {
			
			//查找是否有审批的人员
			String SQLsearchwoker = "SELECT * FROM PRIVI_DOWNLOAD WHERE WOKER_NAME = ?";		
			PreparedStatement pre = connect.prepareStatement(SQLsearchwoker);
			pre.setString(1, user.getCheckname());
			
			ResultSet myresultSetwoker = pre.executeQuery();
			
            if (!myresultSetwoker.isBeforeFirst()) {
            	
				ShowDialog("没有读取到需要下载的数据，你可能没有下载权限，联系管理员帮你设置"); 
				return null;
			}
            
            ArrayList<String> returnNameList = new ArrayList<String>();
            returnNameList.add("全部");
            while (myresultSetwoker.next()) {
            	
            	if (myresultSetwoker.getString("DOWNLOAD_TYPE").equals("Manager")) {
					
            		returnNameList.add(myresultSetwoker.getString("DOWNLOAD_NAME"));
				}
            	
            	else {
            		
            		//查询部门人员
            		
        			String SQLsearchdepartment = "SELECT * FROM WOKERNAMELIST WHERE DEPARTMENT = ?";		
        			PreparedStatement pre2 = connect.prepareStatement(SQLsearchdepartment);
        			pre2.setString(1, myresultSetwoker.getString("DOWNLOAD_NAME"));
        			
        			ResultSet myresultSetpartment= pre2.executeQuery();
        			
                    if (!myresultSetpartment.isBeforeFirst()) {
                    	
        				ShowDialog("没有读取到需要审批的部门人员数据"); 
        				
        			}
                    
                    while (myresultSetpartment.next()) {
                    	
                    	returnNameList.add(myresultSetpartment.getString("NAME"));
                    	
                    }
                    
					
				}
            	            		
            }
            
            DisposeLocalDataBaseLink();

            
            return returnNameList;
        		
		}
		DisposeLocalDataBaseLink();
		return null;
		
	}
	
	
		
	public Date GetTheBiggerTimeInperiod(Date[] period) {
		
		if (period[0] !=null &&period[1] !=null ) {
			
			int result = period[0].compareTo(period[1]);
			
			if (result<0) {
				
				return period[1];
				
			}
			
			else if (result>0) {
				
				return period[0];
			}
			else {

                 Date error = Date.valueOf("9999-12-12");
                 return error;
			}
			
			
		}
		
		Date error = Date.valueOf("9999-12-12");
        return error;
		
	}

    
	public Date GetTheSmallerTimeInperiod(Date[] period) {
		
		
          if (period[0] !=null &&period[1] !=null ) {
			
			int result = period[0].compareTo(period[1]);
			
			if (result<0) {
				
				return period[0];
				
			}
			
			else if (result>0) {
				
				return period[1];
			}
			else {

                 Date error = Date.valueOf("9999-12-12");
                 return error;
			}
			
			
		}
		
		Date error = Date.valueOf("9999-12-12");
        return error;
		
	}
	
	private void ShowDialog(String word) {
		
		JOptionPane.showMessageDialog(null,word, "提示", JOptionPane.INFORMATION_MESSAGE); 
				
	}

}
