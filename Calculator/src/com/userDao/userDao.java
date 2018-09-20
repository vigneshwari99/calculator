package com.userDao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.user.user;

public class userDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Feedback_Form", "postgres", "admin");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(user e) {
		int status = 0;
		try {
			Connection con = userDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into detail(name,pass,email) values (?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPass());
			ps.setString(3, e.getEmail());
			
			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	/*public static boolean validate(String email, String pass) {

		boolean status = false;
		try {
			Connection con = userDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from detail where email=? and pass=?");

			ps.setString(1, email);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if (status) {
				
				String name = rs.getString("name");
				user e = new user();
				e.setName(name);
				 e.setValid(true);
				System.out.println("Welcome " + name);
					
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}*/
	 public static user login(user bean) {
			
         //preparing some objects for connection 
         Statement stmt = null;    
	
         String email = bean.getEmail();    
         String password = bean.getPass();   
	    
         String searchQuery =
               "select * from detail where email='"  + email  + "' AND pass='" + password   + "'";
	    
      // "System.out.println" prints in the console; Normally used to trace the process
      System.out.println("Your user name is " + email);          
      System.out.println("Your password is " + password);
      System.out.println("Query: "+searchQuery);
	    
      try 
      {
         //connect to DB 
         Connection con = userDao.getConnection();
         Statement st= con.createStatement();
         
        		 
      
       ResultSet  rs = st.executeQuery(searchQuery);	        
         boolean more = rs.next();
	       
         // if user does not exist set the isValid variable to false
         if (!more) 
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            bean.setValid(false);
         } 
	        
         //if user exists set the isValid variable to true
         else if (more) 
         {
            String firstName = rs.getString("name");
         
	     	
            System.out.println("Welcome " + firstName);
            bean.setName(firstName);
           
            bean.setValid(true);
         }
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         
      }

return bean;
	
      }	


}
