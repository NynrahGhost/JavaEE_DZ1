package com.KutsenkoMichael;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Auth() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		page(response.getWriter(),"");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("login").equals("admin") && request.getParameter("password").equals("admin")) {
			page(response.getWriter(),"Login succesfull!");
		} else {
			page(response.getWriter(),"Wrong username or password. Try again!");
		}
	}
	
	private void page(PrintWriter pw, String result) {
		pw.append(
				"<html>" +
					"<head>" +
						"<title>Authorization</title>" +
					"</head>" +
					"<body>" +
						"<form action=\"Auth\" method=\"POST\">" +
							"Login: <input required name=\"login\" />\r\n" + 
							"<br><br>\r\n" + 
							"Password: <input required type=\"password\" name=\"password\" />\r\n" +
							"<br><br>\r\n" + 
							"<input type=\"submit\" value=\"Submit\" />\r\n" + 
						"</form>\r\n" + 
						result +
					"</body>\r\n" + 
				"</html>");
	}

}
