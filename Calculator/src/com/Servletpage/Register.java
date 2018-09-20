package com.Servletpage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.user;
import com.userDao.userDao;


/**
 * Servlet implementation class ServerAction
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
         String name=request.getParameter("name");  
         String email=request.getParameter("email");
         String pass = request.getParameter("pass");
        /* String addr = request.getParameter("addr");
         String sid=request.getParameter("num");  
         int id=Integer.parseInt(sid);  */
         
         
          
        user e=new user();  
        e.setName(name); 
       e.setEmail(email);
       e.setPass(pass);
      
       
        int status=userDao.save(e);  
        
        if(status>0){  
            //out.print("<p>Record saved successfully!</p>");  
        	
        	out.print("<center> <p>Registered succesfully!!! </p><center>");
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        		doGet(request, response);
}
}
