package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.text.MessageFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArithmeticServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String content = """ 
				
				<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="arithmetic" method = "Post">

  A = <input type="text" name="a" /><br>
  B = <input type="text" name="b" /><br>
  
    <input type="submit" name="opration" value="Add"/>
    <input type="submit" name="opration" value="Sub"/>
    <input type="submit" name="opration" value="Div"/>
    <input type="submit" name="opration" value="Mul"/>
  
</form>
</body>
</html>
				
			 """;
		
		res.getWriter().print(content);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
	
		String opration = req.getParameter("opration");
		
		int result =0;
		
		if("Add".equals(opration)) {
			result = a + b;
		}
		else if("Sub".equals(opration)) {
			result = a - b;
		}
		else if("Mul".equals(opration)) {
			result = a * b;
		}
		else if("Div".equals(opration)) {
			result = a / b;
		}
		
		System.out.println(MessageFormat.format("A = {0} {1} B = {2} = {3}",a,opration,b,result));
		//System.out.println("A=" +a+ opration + "B=" + b+result);
		
		/*
		 * we nees to store and pass the result to arithmetic
		 * we have to go to the arithmetic.jsp page
		 * */
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("arithmetic.jsp").forward(req, res);
		
		
		
		
		
//		String contant = """
//				
//				<!DOCTYPE html>
//<html>
//<head>
//<meta charset="UTF-8">
//<title>Insert title here</title>
//</head>
//<body>
//
//A = {0}<br/>
//B = {1}<br/>
//Operation = {2}<br/>
//Result = {3}<br/>
//
//<form action="arithmetic" method = "Post">
//
//  A = <input type="text" name="a" /><br>
//  B = <input type="text" name="b" /><br>
//  
//    <input type="submit" name="opration" value="Add"/>
//    <input type="submit" name="opration" value="Sub"/>
//    <input type="submit" name="opration" value="Div"/>
//    <input type="submit" name="opration" value="Mul"/>
//  
//</form>
//</body>
//</html>
//			 """;
//		PrintWriter out = res.getWriter();
//		out.print(MessageFormat.format(contant, a,opration,b,result));
		
	}

}
