package user;

import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import ojdbc.DataBaseOperation;
import ojdbc.LocaltestDataBaseOperation;

public class User {
	
	
	String checkname;
	String usernameString;
	String passwordString;
	String departmentString;
	String id;
	String duty;
	String power_level;
	String whether_manager;
	String level_shape;
	String VACATION_APPROVAL_NORMAL_UPPER;
	String VACATION_APPROVAL_HIGHER_UPPER;
	String ASSESS_APPROVAL_NORMAL_UPPER;
	String ASSESS_APPROVAL_HIGHER_UPPER;
	String Email;
	String VACATION_APPROVAL_NORMAL_RIGHT;
	String VACATION_APPROVAL_HIGHER_RIGHT;
	String ASSESS_APPROVAL_NORMAL_RIGHT;
	String ASSESS_APPROVAL_HIGHER_RIGHT;
	
		
	public String getCheckname() {
		return checkname;
	}


	public String getUsernameString() {
		return usernameString;
	}


	public String getPasswordString() {
		return passwordString;
	}


	public String getDepartmentString() {
		return departmentString;
	}
	
	
	public String getId() {
		return id;
	}
	
	


	public String getPower_level() {
		return power_level;
	}


	public String getWhether_manager() {
		return whether_manager;
	}


	public String getLevel_shape() {
		return level_shape;
	}





	public String getVACATION_APPROVAL_NORMAL_UPPER() {
		return VACATION_APPROVAL_NORMAL_UPPER;
	}


	public String getVACATION_APPROVAL_HIGHER_UPPER() {
		return VACATION_APPROVAL_HIGHER_UPPER;
	}


	public String getASSESS_APPROVAL_NORMAL_UPPER() {
		return ASSESS_APPROVAL_NORMAL_UPPER;
	}


	public String getASSESS_APPROVAL_HIGHER_UPPER() {
		return ASSESS_APPROVAL_HIGHER_UPPER;
	}


	public String getEmail() {
		return Email;
	}


	public String getVACATION_APPROVAL_NORMAL_RIGHT() {
		return VACATION_APPROVAL_NORMAL_RIGHT;
	}


	public String getVACATION_APPROVAL_HIGHER_RIGHT() {
		return VACATION_APPROVAL_HIGHER_RIGHT;
	}


	public String getASSESS_APPROVAL_NORMAL_RIGHT() {
		return ASSESS_APPROVAL_NORMAL_RIGHT;
	}


	public String getASSESS_APPROVAL_HIGHER_RIGHT() {
		return ASSESS_APPROVAL_HIGHER_RIGHT;
	}


	private User(String checkname,String usernameString,String passwordString,String id,String departmentString
                 ,String duty,String power_level,String whether_manager,String level_shape,
                 String VACATION_APPROVAL_NORMAL_UPPER,String VACATION_APPROVAL_HIGHER_UPPER,
                 String ASSESS_APPROVAL_NORMAL_UPPER,String ASSESS_APPROVAL_HIGHER_UPPER,String emailstring,
                 String VACATION_APPROVAL_NORMAL_RIGHT,String VACATION_APPROVAL_HIGHER_RIGHT,String ASSESS_APPROVAL_NORMAL_RIGHT,
                 String ASSESS_APPROVAL_HIGHER_RIGHT)
	{		
		this.checkname = checkname;
		this.usernameString = usernameString;
		this.passwordString = passwordString;
		this.departmentString = departmentString;
		this.id = id;
		this.duty = duty;
		this.power_level = power_level;
		this.whether_manager = whether_manager;
		this.level_shape = level_shape;
		this.VACATION_APPROVAL_NORMAL_UPPER = VACATION_APPROVAL_NORMAL_UPPER;
		this.VACATION_APPROVAL_HIGHER_UPPER = VACATION_APPROVAL_HIGHER_UPPER;
		this.ASSESS_APPROVAL_NORMAL_UPPER= ASSESS_APPROVAL_NORMAL_UPPER;
		this.ASSESS_APPROVAL_HIGHER_UPPER = ASSESS_APPROVAL_HIGHER_UPPER;
		this.Email = emailstring;
		this.ASSESS_APPROVAL_NORMAL_RIGHT = ASSESS_APPROVAL_NORMAL_RIGHT;
		this.ASSESS_APPROVAL_HIGHER_RIGHT = ASSESS_APPROVAL_HIGHER_RIGHT;
		this.VACATION_APPROVAL_NORMAL_RIGHT = VACATION_APPROVAL_NORMAL_RIGHT;
		this.VACATION_APPROVAL_HIGHER_RIGHT = VACATION_APPROVAL_HIGHER_RIGHT;
		
	}
	
	
	public static User GetUserData(String usernameString,String passwordString)	
	{
			return null;
	
	}
	
		
	public static boolean RegisterUser(String checkname,String usernameString,String passwordString,String emailstring) throws ClassNotFoundException, SQLException
	{
		
//		LocaltestDataBaseOperation localtestDataBaseOperation = new LocaltestDataBaseOperation();
//		return localtestDataBaseOperation.InsertIntoOneLine_DATA_ACCOUNT(usernameString, passwordString, checkname,emailstring);
		
		DataBaseOperation testBaseOperation = new DataBaseOperation();			
		return testBaseOperation.InsertIntoOneLine_DATA_ACCOUNT(usernameString, passwordString, checkname,emailstring);
				
	}
	
	
	
	public static Map<User, String> LoginInUser (String usernameString,String passwordString) throws ClassNotFoundException, SQLException 	
	{
		
		
		if (usernameString.equals("")||passwordString.equals("")) {
			User returnUser = null;
			Map<User, String> resultmap = new HashMap<User, String>();		
			resultmap.put(returnUser, "帐号密码为空");
			return resultmap;
		}
		
		
//		LocaltestDataBaseOperation localtestDataBaseOperation = new LocaltestDataBaseOperation();
//		Map<ArrayList<String>, String> resultString = localtestDataBaseOperation.SelectOneLine_DATA_ACCOUNT(usernameString, passwordString);
		
		DataBaseOperation testBaseOperation = new DataBaseOperation();		
		Map<ArrayList<String>, String> resultString = testBaseOperation.SelectOneLine_DATA_ACCOUNT(usernameString, passwordString);
				
		Set<Map.Entry<ArrayList<String>, String>> set = resultString.entrySet();					
		Iterator<Map.Entry<ArrayList<String>, String>> iterator = set.iterator();
				
		String logininreturnString = null;
		ArrayList<String> resultArrayList = null; 
		
		while (iterator.hasNext()) {
			
			Map.Entry<ArrayList<String>, String> returnresult= (Map.Entry<ArrayList<String>, String>) iterator.next();
            resultArrayList = returnresult.getKey();
            logininreturnString = returnresult.getValue();
					
		}
						
		if (logininreturnString.equals("成功登录")) {
			
			User returnUser = new User(resultArrayList.get(0), resultArrayList.get(1), resultArrayList.get(2), resultArrayList.get(3),resultArrayList.get(4),resultArrayList.get(5),resultArrayList.get(6),resultArrayList.get(7),resultArrayList.get(8),resultArrayList.get(9),resultArrayList.get(10),resultArrayList.get(11),resultArrayList.get(12),resultArrayList.get(13),resultArrayList.get(14),resultArrayList.get(15),resultArrayList.get(16),resultArrayList.get(17));
			Map<User, String> resultmap = new HashMap<User, String>();			
			resultmap.put(returnUser, "成功登录");
			return resultmap;
		}
		
		else if (logininreturnString.equals("帐号或者密码错误")) {
			
			User returnUser = null;
			Map<User, String> resultmap = new HashMap<User, String>();			
			resultmap.put(returnUser, "帐号或者密码错误");		
			resultmap.put(returnUser, "帐号或者密码错误");	
			resultmap.put(returnUser, "帐号或者密码错误");	
			return resultmap;
		}
		
		else if (logininreturnString.equals("数据库中没有读取到任何帐号数据，请联系管理员")) {
			
			User returnUser = null;
			Map<User, String> resultmap = new HashMap<User, String>();			
			resultmap.put(returnUser, "数据库中没有读取到任何帐号数据，请联系管理员");			
			return resultmap;
		}
		
		else if (logininreturnString.equals("数据库连接错误")) {
			
			User returnUser = null;
			Map<User, String> resultmap = new HashMap<User, String>();		
			resultmap.put(returnUser, "数据库连接错误");			
			return resultmap;
		}
		
		return null;
								
	}
	
	
	private static void ShowDialog(String word) {
		
		JOptionPane.showMessageDialog(null,word, "错误ʾ", JOptionPane.ERROR_MESSAGE); 
				
	}
	

}
