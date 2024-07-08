package com.tw.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int firstNum = Integer.parseInt(request.getParameter("firstnum"));
		String cal = request.getParameter("cal");
		int secondNum = Integer.parseInt(request.getParameter("secondnum"));
		int result = 0;
		
		if(cal.equals("+")) {
			result = firstNum + secondNum;
		}else if(cal.equals("-")) {
			result = firstNum - secondNum;
		}else if(cal.equals("x")) {
			result = firstNum * secondNum;
		}else if(cal.equals("/")) {
			result = firstNum / secondNum;
		}else if(cal.equals("%")) {
			result = firstNum % secondNum;
		}
//		switch(cal){
//		case "+" :
//			result = firstNum + secondNum;
//		break;
//		case "-" : break;
//		case "x" : break;
//		case "/" : break;
//		case "%" : break;
//		}
		
		request.setAttribute("firstnum", firstNum);
		request.setAttribute("secondnum", secondNum);
		request.setAttribute("cal", cal);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/calculator/resultCalc.jsp").forward(request, response);
	}
	

}
