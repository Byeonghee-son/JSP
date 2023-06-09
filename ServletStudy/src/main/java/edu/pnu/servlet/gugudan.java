package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = req.getParameter("type");
		String snum = req.getParameter("num");
		
		int num = 2;
		if(snum != null) num = Integer.parseInt(snum);
		resp.setContentType("text/html; charset=utf-8");
		try(PrintWriter out = resp.getWriter();){
			
			out.println("<h2>구구단 타입 3 (Servlet)</h2>");
			out.println("<h3>구구단 " + num + " 단입니다.</h3>");
			
			if ("list".equals(type)) {
	            out.println("<ul>");
	            for (int i = 1; i <= 9; i++) {
	                out.println("<li>" + num + " * " + i + " = " + num * i + "</li>");
	            }
	            out.println("</ul>");
	        } else if ("table".equals(type)) { 
	            out.println("<table border=\"1\" style=\"width:200px; text-align:center;\">");
	            for (int i = 1; i <= 9; i++) {
	                out.println("<tr><td>" + num + " * " + i + "</td><td>=</td><td>" + num * i + "</td></tr>");
	            }
	            out.println("</table>");
	       
	        }else {
	            out.println("<ul>");
	            for (int i = 1; i <= 9; i++) {
	                out.println("<li>" + num + " * " + i + " = " + num * i + "</li>");
	            }
	            out.println("</ul>");
	        }
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	
	
		
	}
}
