package ojdbc;

import java.io.IOException;
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

import excel.wrtieExcel;
import jxl.write.WriteException;
import tcp.ListInformation;
import user.User;
import vacation_extrawork.Approvel_N_Dayinformation;
import vacation_extrawork.Dayinformation;
import vacation_extrawork.OneManData;

public class DataBaseOperation {
	
	Connection connect = null;
    Statement statement = null;
    ResultSet resultSet = null;
	
	
	public Connection LinkToDataBase() throws ClassNotFoundException, SQLException {
			
		connect = DriverManager.getConnection("jdbc:oracle:thin:@111.230.138.68:1523:VAChecking", "C##MY", "z456788002");		
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
		
		LinkToDataBase();
		
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
			DisposeDataBaseLink();									
			return true;
						
		}
		else {
			System.out.println("链接没有建立成功");
			DisposeDataBaseLink();
			return false;
		}
			
	}
	
	public boolean DeleteOneLine_DATA_VACATIONANDOVERWORK(String name,int id,Date time,
            String ACTUALTIMENOCLEAR) throws SQLException, ClassNotFoundException {
		
		LinkToDataBase();
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
			 DisposeDataBaseLink();	
			return true;
				
		 }
		 else {
			 DisposeDataBaseLink();	
			return false;
		 }
		}
		else {
			DisposeDataBaseLink();	
			return false;
		}
			
	}
	
	public boolean InsertIntoOneLine_DATA_WOKERNAMELIST(int id,String name) throws SQLException, ClassNotFoundException {
		
		LinkToDataBase();
		if (connect!=null) {
			
			String sql = "INSERT INTO WOKERNAMELIST (ID,NAME) VALUES (?,?)";		
			PreparedStatement pre = connect.prepareStatement(sql);			
			pre.setInt(1, id);
			pre.setString(2,name);				
			pre.execute();		
			DisposeDataBaseLink();	
			return true;
									
		}
		else {
			System.out.println("链接没有建立成功");
			DisposeDataBaseLink();	
			return false;
		}
		
	}
	
	public int GetID_from_Nanme(String name) throws ClassNotFoundException, SQLException {
		
		LinkToDataBase();
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
		DisposeDataBaseLink();
		return id;
		
	}
	
	
	public void InsertInto_DATA_VACATIONANDOVERWORK_ONEMANDATAGROUP(ArrayList<OneManData> data) throws ClassNotFoundException, SQLException {
		
		LinkToDataBase();
		
		if (connect!=null) {
			
			connect.setAutoCommit(false);
			String onelineSQL = "INSERT INTO VACATION_NAPPROVAL (name,id,time,ACTUALTIMENOCLEAR,REASONS,REASONS_DETAILS,REASONS_EXPLANATION,HANDLEOVERTIMEWORK,VACATION_NORMAL_PASSED,LEVEL_SHAPE,DEPARTMENT)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pre = connect.prepareStatement(onelineSQL);					
			Iterator<OneManData> onemaniIterator = data.iterator();
			
			while (onemaniIterator.hasNext()) {
				OneManData dataforoneman = (OneManData)onemaniIterator.next();
				
				Iterator<Approvel_N_Dayinformation> dayinformationIterator = dataforoneman.getN_dayinformation().iterator();
				
				while (dayinformationIterator.hasNext()) {
					Approvel_N_Dayinformation datafordayinformaiton = (Approvel_N_Dayinformation)dayinformationIterator.next();

					pre.setString(1,dataforoneman.getName());
					pre.setString(2,String.valueOf(dataforoneman.getId()));
					pre.setDate(3, datafordayinformaiton.getTime());
					pre.setString(4,datafordayinformaiton.getActualtimenoclear());
					pre.setString(5,datafordayinformaiton.getreasons());
					pre.setString(6,datafordayinformaiton.getreasons_details());
					pre.setString(7,datafordayinformaiton.getreasons_explanation());
					pre.setString(8,datafordayinformaiton.gethandleovertimework());	
					pre.setInt(9, datafordayinformaiton.getVACATION_NORMAL_PASSED());
					pre.setString(10, datafordayinformaiton.getLEVEL_SHAPE());
					pre.setString(11, datafordayinformaiton.getDEPARTMENT());
					pre.addBatch();
										
				}
				
			}
			int[] result = pre.executeBatch();
											
		}
		
		DisposeDataBaseLink();
		
				
	}
	
	
	public ListInformation Selectfrom_DATA_VACATIONANDOVERWORK_Downloadchoose_ForOneName(String name,String reason,String reasondetail,Date[] period) throws ClassNotFoundException, SQLException {
		
        LinkToDataBase();
        
		if (connect!=null) {
			
			String sqlString ="select * from DATA_VACATIONANDOVERWORK where Time>= ? and Time<= ?";
								
			if (!name.equals("全部")) {
				sqlString += "and name = ?";
			}
					
			if (!reason.equals("全部")) {
				
				sqlString += "and reasons = ?";
			}
			
			if (!reasondetail.equals("全部")) {
				
				sqlString += "and REASONS_DETAILS = ?";
			}
			
			
			PreparedStatement pre = connect.prepareStatement(sqlString);
			ParameterMetaData parameterMetaData = null;
			parameterMetaData = pre.getParameterMetaData();
			int count = parameterMetaData.getParameterCount();
			System.out.println(count);
			
			if (count ==2) {
				
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
				DisposeDataBaseLink();
				return informationgroup;
				
			}
			
			
			
			
			if (count == 3) {
				
				pre.setDate(1, GetTheSmallerTimeInperiod(period));
				pre.setDate(2, GetTheBiggerTimeInperiod(period));
				pre.setString(3, name);
				
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
				DisposeDataBaseLink();
				return informationgroup;
			}
			
			if (count == 4) {
				
				
				pre.setDate(1, GetTheSmallerTimeInperiod(period));
				pre.setDate(2, GetTheBiggerTimeInperiod(period));
				pre.setString(3, name);
				pre.setString(4, reason);
				
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
				DisposeDataBaseLink();
				return informationgroup;
				
			}
			
	        if (count == 5) {
				
				
				pre.setDate(1, GetTheSmallerTimeInperiod(period));
				pre.setDate(2, GetTheBiggerTimeInperiod(period));
				pre.setString(3, name);
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
				DisposeDataBaseLink();
				return informationgroup;
				
			}
			ShowDialog("程序出错联系管理员");
			return null;
		}
		DisposeDataBaseLink();
		return null;
				
	}
	
	public boolean InsertIntoOneLine_DATA_ACCOUNT(String username,String password,String workname,String email) throws ClassNotFoundException, SQLException {
		
	       LinkToDataBase();
	       
			int id = -1;
			String duty = null;
			String department = null;
			String level_shape = null;
			int power_level = -1;
			int whethermanager =-1;
			int vacation_approval_normal = -1;
			int vacation_approval_higher = -1;
			int assess_approval_normal = -1;
			int assess_approval_higher = -1;
			
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
				
				
				String sqlgetpower = "SELECT * FROM POWER WHERE duty =? ";
				PreparedStatement pregetpower = connect.prepareStatement(sqlgetpower);			
				pregetpower.setString(1, duty);		
				ResultSet resultgetpower =pregetpower.executeQuery();
				
				
				if (!resultgetpower .isBeforeFirst()) {
					
					ShowDialog("在power表中不能查找到该duty，联系管理员");
					return false;
				}
				
				while (resultgetpower.next()) {
					
					power_level = resultgetpower.getInt("power_level");
					whethermanager = resultgetpower.getInt("whethermanager");
										
				}
				
				//从MANAGER_RELATIONSHIP取出vacation和assess权限
				
				

				String sqlgetvacationassess = "SELECT * FROM MANAGER_RELATIONSHIP WHERE MANAGER_NAME = ?";
				PreparedStatement pregetvacationassess = connect.prepareStatement(sqlgetvacationassess);			
				pregetvacationassess.setString(1, workname);		
				ResultSet resultgetvacationasses =pregetvacationassess.executeQuery();
				
				
				if (!resultgetvacationasses.isBeforeFirst()) {
					
					String sqlgetvacationassess2 = "SELECT * FROM MANAGER_RELATIONSHIP WHERE MANAGER_NAME = ?";
					PreparedStatement pregetvacationassess2 = connect.prepareStatement(sqlgetvacationassess2);			
					pregetvacationassess2.setString(1, department);		
					ResultSet resultgetvacationasses2 =pregetvacationassess2.executeQuery();
					
					if (!resultgetvacationasses2.isBeforeFirst())
					{
						ShowDialog("在MANAGER_RELATIONSHIP表中不能查找到vacation和assess权限，联系管理员");
						return false;
						
					}
					
					while (resultgetvacationasses2.next()) {
						
						vacation_approval_normal = resultgetvacationasses2.getInt("vacation_approval_normal");
						vacation_approval_higher = resultgetvacationasses2.getInt("vacation_approval_higher");
						assess_approval_normal = resultgetvacationasses2.getInt("assess_approval_normal");
						assess_approval_higher = resultgetvacationasses2.getInt("assess_approval_higher");
											
					}
					
					
				}
				
				while (resultgetvacationasses.next()) {
					
					vacation_approval_normal = resultgetvacationasses.getInt("vacation_approval_normal");
					vacation_approval_higher = resultgetvacationasses.getInt("vacation_approval_higher");
					assess_approval_normal = resultgetvacationasses.getInt("assess_approval_normal");
					assess_approval_higher = resultgetvacationasses.getInt("assess_approval_higher");
										
				}
				
								
				//尝试插入帐号
				
				
										
				String insertaccountsql = "INSERT INTO ACCOUNT (username,password,WOKERNAME,id,DEPARTMENT,duty,power_level,whethermanager,level_shape,vacation_approval_normal,vacation_approval_higher,assess_approval_normal,assess_approval_higher,email)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
				preinsertaccount.setInt(10, vacation_approval_normal);
				preinsertaccount.setInt(11, vacation_approval_higher);
				preinsertaccount.setInt(12, assess_approval_normal);
				preinsertaccount.setInt(13, assess_approval_higher);
				preinsertaccount.setString(14, email);
				
								
				int result = preinsertaccount.executeUpdate();
				
				
				if (result == 0) {
					
					return false;
					
				}
				
				if (result == 1) {
					
					return true;
					
				}
							
			}
			
			DisposeDataBaseLink();			
			return false;		
	}
	
	public Map<ArrayList<String>, String> SelectOneLine_DATA_ACCOUNT(String username,String password) throws ClassNotFoundException, SQLException
	{
		LinkToDataBase();
		
		if (connect!=null) {
			
			String SelectSQL = "SELECT * FROM account";
			PreparedStatement pre = connect.prepareStatement(SelectSQL);
			ResultSet myresultSet = pre.executeQuery();
			
			if (!myresultSet.isBeforeFirst()) {
				
				Map<ArrayList<String>, String> resutMap = new HashMap<ArrayList<String>, String>();
				resutMap.put(new ArrayList<String>(), "数据库中没有读取到任何帐号数据，请联系管理员");	
				DisposeDataBaseLink();
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
				String VACATION_APPROVAL_NORMAL = myresultSet.getString("VACATION_APPROVAL_NORMAL");
				String VACATION_APPROVAL_HIGHER = myresultSet.getString("VACATION_APPROVAL_HIGHER");
				String ASSESS_APPROVAL_NORMAL = myresultSet.getString("ASSESS_APPROVAL_NORMAL");
				String ASSESS_APPROVAL_HIGHER = myresultSet.getString("ASSESS_APPROVAL_HIGHER");
												
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
						userinformationArrayList.add(VACATION_APPROVAL_NORMAL);
						userinformationArrayList.add(VACATION_APPROVAL_HIGHER);
						userinformationArrayList.add(ASSESS_APPROVAL_NORMAL);
						userinformationArrayList.add(ASSESS_APPROVAL_HIGHER);
						resutMap.put(userinformationArrayList, "成功登录");						
						DisposeDataBaseLink();
						return resutMap;
					}
				}
				
			}
			
			Map<ArrayList<String>, String> resutMap = new HashMap<ArrayList<String>, String>();
			resutMap.put(new ArrayList<String>(), "帐号或者密码错误");
			DisposeDataBaseLink();
			return resutMap;
									
		}
		
		Map<ArrayList<String>, String> resutMap = new HashMap<ArrayList<String>, String>();
		resutMap.put(new ArrayList<String>(), "数据库连接错误");		
		DisposeDataBaseLink();
		return resutMap;
		
	}
	
	public ListInformation Selectfrom_DATA_VACATION_WORK_APPROVAL_ForUser(User user) throws ClassNotFoundException, SQLException {
		
       LinkToDataBase();
		
		if (connect!=null) {
						
			int VACATION_APPROVAL_NORMAL = Integer.valueOf(user.getVACATION_APPROVAL_NORMAL());
			int VACATION_APPROVAL_HIGHER = Integer.valueOf(user.getVACATION_APPROVAL_HIGHER());
			String level_shape = user.getLevel_shape();
						
			if (VACATION_APPROVAL_NORMAL ==1) {
				
				String SelectSQL = "SELECT * FROM VACATION_NAPPROVAL WHERE VACATION_NORMAL_PASSED = 0 and level_shape LIKE";
				SelectSQL += "'"+user.getLevel_shape()+"."+"%"+"'";			
				PreparedStatement pre = connect.prepareStatement(SelectSQL);
				System.out.println(SelectSQL);
				ResultSet myresultSet = pre.executeQuery();
				
                if (!myresultSet.isBeforeFirst()) {
                	
    				ShowDialog("暂时没有读取到需要审批的数据"); 
					return null;
				}
                
                ListInformation informationgroup = new ListInformation();
                while (myresultSet.next()) {
					
                	String NAME = myresultSet.getString("NAME");
                	Date time = myresultSet.getDate("time");
                	String timeString = time.toString();
                	String ACTUALTIMENOCLEAR = myresultSet.getString("ACTUALTIMENOCLEAR");
                	String REASONS_DETAILS = myresultSet.getString("REASONS_DETAILS");
                	String DEPARTMENT= myresultSet.getString("DEPARTMENT");
                	String REASONS_EXPLANATION = myresultSet.getString("REASONS_EXPLANATION");
                	
                	ArrayList<String> arrayList = new ArrayList<String>();
                	arrayList.add(NAME);
                	arrayList.add(timeString);
                	arrayList.add(ACTUALTIMENOCLEAR);
                	arrayList.add(REASONS_DETAILS);
                	arrayList.add(DEPARTMENT);
                	arrayList.add(REASONS_EXPLANATION);
                	           	
                	informationgroup.getLineinformationgroup().add(arrayList);
                						
				}
				DisposeDataBaseLink();
				return informationgroup;
				
			}
			
			
					
			
		}
		
		DisposeDataBaseLink();
		return null;
		
	}
	
	
	public void Update_VACATION_WORK_NORMOL_APPROVAL_state(ListInformation datagroup) throws SQLException, ClassNotFoundException {
		
		  LinkToDataBase();
			
		  
			if (connect!=null) {
				
				//更新表单请假状态记号
				String SQL1 = "UPDATE VACATION_NAPPROVAL SET VACATION_NORMAL_PASSED = 1 WHERE name = ? and ACTUALTIMENOCLEAR = ? and to_char(time,'yyyy-mm-dd')=? ";		
				PreparedStatement pre = connect.prepareStatement(SQL1);
				
				
				for (ArrayList<String> data : datagroup.getLineinformationgroup()) {
					
					pre.setString(1, data.get(0));
					pre.setString(2, data.get(1));
					pre.setString(3, data.get(2));					
					pre.addBatch();
					
				}
				
				int[] myresultSet = pre.executeBatch();
				
				//转移数据
				
				String SQL2 = "insert into DATA_VACATIONANDOVERWORK(name,id,time,ACTUALTIMENOCLEAR,REASONS,REASONS_DETAILS,REASONS_EXPLANATION,HANDLEOVERTIMEWORK) select name, id ,time ,ACTUALTIMENOCLEAR, REASONS, REASONS_DETAILS,REASONS_EXPLANATION,HANDLEOVERTIMEWORK from VACATION_NAPPROVAL where VACATION_NORMAL_PASSED = 1";	
				PreparedStatement pre2 = connect.prepareStatement(SQL2);
				pre2.executeUpdate();
				 
				//
				
				//删除原数据
				String SQL3 = "DELETE FROM VACATION_NAPPROVAL WHERE VACATION_NORMAL_PASSED  = 1";	
				PreparedStatement pre3 = connect.prepareStatement(SQL3);
				pre3.executeUpdate();
				
				ShowDialog("审批提交成功");
			}
		
		DisposeDataBaseLink();
		
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
