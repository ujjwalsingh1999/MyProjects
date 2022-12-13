package com.project.contactManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcConnection {

	public static void main(String[] args)throws SQLException, Exception {
		// TODO Auto-generated method stub
		Connection connection=null;
		final  contactDetails addobj =new contactDetails();//creating obj 
		Class.forName("com.mysql.jdbc.Driver");//register driver class
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactDB", "root" ,"");//establishing connection
		System.out.println("enter 1 for addContactDetails");
		System.out.println("enter 2 for update Contact");
		System.out.println("enter 3 for delete Contact");
		System.out.println("enter 4 for View Contact Details");
		System.out.println("enter your choice");
		int choice = obj.nextByte();
		switch(choice) {
			case 1:
				contactDetails obj =  getSoftwareDetails ();
				if(connection!=null) {
					addContactDetails(connection,obj);//method call
				}
				else {
					System.out.println("check your connection");
				}


				break;
			case 2:

				System.out.println("enter which record do you want to update");
				update(connection,983870);

				break;
			case 3:
				System.out.println("enter which record do you want to delete");
				delete(connection,125);

				break;
			case 4:
				System.out.println("enter id to read the record");
				view(connection,145);

				break;

			default:
				System.out.println("enter proper choice");
				connection.close();
		}

	}
	
	private static contactDetails getSoftwareDetails() {//reading values from class SoftwareDetails
		contactDetails user = new contactDetails ();
		System.out.println("enter contactName");
		user.setcontactName(obj.next());
		System.out.println("enter contact_id");
		user.setcontact_id(obj.nextInt());
		System.out.println("enter contactdescription ");
		user.setcontactdescription(obj.next());
		System.out.println("enter phone");
		obj.skip("\\R?");
		user.setphone(obj.nextInt());
		System.out.println("enter contactEmail");
		user.setcontactEmail(obj.next());
		return user;

	}
	
	static final Scanner obj=new Scanner(System.in);
	public static void update(Connection connection,int contact_id) throws SQLException {//method for to update record
		PreparedStatement pstmt = connection.prepareStatement("update  contactDB_TBL set  phone=? where contact_id=?");//update query
		String value=obj.next();
		pstmt.setInt(1,contact_id);
		pstmt.setString(2,value);
		int record=pstmt.executeUpdate();
		System.out.println(record);

	}

	public static void addContactDetails(Connection connection,contactDetails  obj) throws SQLException {//method for inserting values
		PreparedStatement pstmt = connection.prepareStatement("insert into contactDB_TBL values(?,?,?,?,?)");//select query alike as in mysql
		pstmt.setInt(1,obj.getcontact_id());//12
		pstmt.setString(2,obj.getcontactName());//Suhash
		pstmt.setString(3,obj.getcontactdescription());//about contact
		pstmt.setInt(4,obj.getphone());//2000
		pstmt.setString(5,obj.getcontactEmail());//ujjwal@gmail.com

		int record=pstmt.executeUpdate();//execute query
		System.out.println(record);//how many elements are added that means it will give count

	}
	public static void delete(Connection connection,int contact_id) throws SQLException {//method for to delete record
		PreparedStatement pstmt = connection.prepareStatement("delete from contactDB_TBL where contact_id=?");//dlete query
		int val=obj.nextInt();
		pstmt.setInt(1, val);
		int record=pstmt.executeUpdate();//execute query
		System.out.println(record);//how many records are 

	}
	public static void view(Connection connection,int contact_id) throws SQLException {//method for to view record
		PreparedStatement pstmt = connection.prepareStatement("select * from contactDB_TBL where contact_id=?");//selct query same as mysql
		int id=obj.nextInt();
		pstmt.setInt(1,id);
		ResultSet record=pstmt.executeQuery();
		while(record.next()) {
			System.out.println(record.getInt(1)+" "+record.getString(2)+" "+record.getString(3)+" "+record.getInt(4)+" "+record.getString(5));

		}

	}

}


