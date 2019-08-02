package zzzz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseOperation {
	
	Connection connect = null;
    Statement statement = null;
    ResultSet resultSet = null;
	
	
	public Connection LinkToDataBase() throws ClassNotFoundException, SQLException {
			
		connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##MY", "z456788002");		
        System.out.println(connect);         
        return connect;
               						
	}
	
	public void DisposeDataBaseLink() throws SQLException {
		
		if (statement!=null) {statement.close();}
		if (resultSet!=null) {resultSet.close();}
		if (connect!=null) {connect.close();}
		
	}
	
	public boolean InsertIntoOneLine_DATA_VACATIONANDOVERWORK(String name,int id,Date time,
			                                                  String ACTUALTIMENOCLEAR,String REASONS,
			                                                  String REASONS_DETAILS,String REASONS_EXPLANATION,String HANDLEOVERTIMEWORK) throws SQLException, ClassNotFoundException {
		
		LinkToDataBase();
		
		if (connect!=null) {
			
			String sql = "INSERT INTO PRODUCTDETAILS (name,id,time,ACTUALTIMENOCLEAR,REASONS,REASONS_DETAILS,REASONS_EXPLANATION,HANDLEOVERTIMEWORK)VALUES(?,?,?,?,?,?,?,?)";
			
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
	
	public boolean InsertIntoOneLine_DATA_WOKERNAMELIST(String nameString,String typenumber,String guigeString,float  price,float  taoshu) throws SQLException, ClassNotFoundException {
		
		

		
		
		LinkToDataBase();
		if (connect!=null) {
			
			String sql = "INSERT INTO WOKERNAMELIST (ID,NAME) VALUES (?,?)";		
			PreparedStatement pre = connect.prepareStatement(sql);			
			pre.setString(1, nameString);
			pre.setString(2,typenumber);				
			pre.setString(3,guigeString);				
			pre.setFloat(4, price);
			pre.setFloat(5, taoshu);
		
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
	
	

}
