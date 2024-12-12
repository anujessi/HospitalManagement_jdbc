package hospitalmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalApp {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("choose options ");
			System.out.println("1. Register new Patient by accepting all details");
			System.out.println("2.Update the desiese information by patient id");
			System.out.println("3.Apdate the phone Number  by Patient Id by name");
			System.out.println("4.fetch all patients Details");
			System.out.println("5. fetch patient details by diease");
			System.out.println("6. fetch patient Details by name");
			System.out.println("7. delete patient record by patient id");
			System.out.println("8.search patient by letter of the name");
			System.out.println(" 9.Exit");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				registerPatientByAcceptingDetails();
				break;
			case 2: updatePatieDieseasById();
			break;
			case 3:updatePhoneNoByPatientIdAndName();
			break;
			case 4:featchAllPatientDetails();
			break;
			case 5:featchPatientDetailsByDiesease();
			break;
			case 6:featchPatientDetailsByName();
			break;
			case 7:deletePatientRecordById();
			break;
			case 8:searchPatientByLetterOfTheName();
			break;
			case 9:exit();
			break;
			default:System.out.println(" invalid choice");
				
				
			}

		}

	}

	private static void exit() {
System.out.println("Thank you visit again");		
	}

	private static void searchPatientByLetterOfTheName() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			PreparedStatement ps=con.prepareStatement("select * from patient where name like?");
		System.out.println(" Enter letter");
		ps.setString(1, s.next()+"%");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1)+" ");
			System.out.print(rs.getString(2)+" ");
			System.out.print(rs.getInt(3)+" ");
			System.out.print(rs.getString(4)+" ");
			System.out.print(rs.getLong(5)+" ");
			System.out.print(rs.getString(6)+" ");
			System.out.println(rs.getString(7)+" ");
		}
		rs.close();
		ps.close();
		con.close();
		 
	
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}

	private static void deletePatientRecordById() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			PreparedStatement ps=con.prepareStatement("delete from patient where id=?");
			System.out.println(" Enter id");
			ps.setInt(1, s.nextInt());
			int row=ps.executeUpdate();
			System.out.println(row+"row: deleted");
			ps.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void featchPatientDetailsByName() {
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
	PreparedStatement ps=con.prepareStatement(" select * from patient where name=?");
	System.out.println(" enter name");
	ps.setString(1, s.next());
	ResultSet rs=ps.executeQuery();
while(rs.next()) {
		System.out.print(rs.getInt(1)+" ");
		System.out.print(rs.getString(2)+" ");
		System.out.print(rs.getInt(3)+" ");
		System.out.print(rs.getString(4)+" ");
		System.out.print(rs.getLong(5)+" ");
		System.out.print(rs.getString(6)+" ");
		System.out.println(rs.getString(7)+" ");
	}
	rs.close();
	ps.close();
	con.close();
	
	
	
	

			
} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
}		
	}

	private static void featchPatientDetailsByDiesease() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			PreparedStatement ps=con.prepareStatement("select *  from patient where disease =?");
			System.out.println(" Enter disease");
			ps.setString(1, s.next());
			ResultSet rs=ps.executeQuery();
	while(rs.next()) {
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getInt(3)+" ");
				System.out.print(rs.getString(4)+" ");
				System.out.print(rs.getLong(5)+" ");
				System.out.print(rs.getString(6)+" ");
				System.out.println(rs.getString(7));

				
			}
			
			rs.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void featchAllPatientDetails() {
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
	PreparedStatement ps=con.prepareStatement("select* from patient");
	ResultSet rs=ps.executeQuery();
while(rs.next()) {
		System.out.print(rs.getInt(1)+"");
		System.out.print(rs.getString(2)+"");
		System.out.print(rs.getInt(3)+"");
		System.out.print(rs.getString(4)+"");
		System.out.print(rs.getLong(5)+"");
		System.out.print(rs.getString(6)+"");
		System.out.println(rs.getString(7)+"");
	}
	rs.close();
	ps.close();
	con.close();
	
	
	
} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
}		
	}

	private static void updatePhoneNoByPatientIdAndName() {
try {
	Class.forName("com.mysql.cj.jdbc.Driver")	;
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
	PreparedStatement ps=con.prepareStatement("update patient set phone_no=? where id=? and name=?");
	System.out.println(" Enter phone_no");
	ps.setLong(1, s.nextLong());
	System.out.println(" Enter id");
	ps.setInt(2,s.nextInt());
	System.out.println(" Enter name");
	ps.setString(3, s.next());
	int row=ps.executeUpdate();
	System.out.println(row+"row:updated");
	ps.close();
	con.close();
	
} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
}	
	}

	private static void updatePatieDieseasById() {
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			PreparedStatement ps=con.prepareStatement("update patient set disease=? where id=?");
			System.out.println(" Enter disease");
			ps.setString(1, s.next());
			System.out.println("Enter id");
			ps.setInt(2, s.nextInt());
		int row=	ps.executeUpdate();
		System.out.println(row+":Row updated");
		ps.close();
		con.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void registerPatientByAcceptingDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
			System.out.println("enter id");
			ps.setInt(1, s.nextInt());
			System.out.println(" enter name");
			ps.setString(2, s.next());
			System.out.println("enter age");
			ps.setInt(3, s.nextInt());
			System.out.println("Enter Gender");
			ps.setString(4, s.next());
			System.out.println("Enter phone number");
			ps.setLong(5, s.nextLong());
			System.out.println(" Enter disease");
			ps.setString(6, s.next());
			System.out.println(" Enter admission Date");
			ps.setString(7, s.next());
			int row = ps.executeUpdate();
			System.out.println(row+"row inserted");
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
