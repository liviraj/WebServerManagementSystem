package com.gms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.model.BeenLogin;
import com.gms.model.GroceryBeen;
import com.gms.service.GroceryService;
import com.gms.service.LoginServiceEMS;

/**
 * Servlet implementation class LoginHomeController
 */
@WebServlet("/LoginHomeController")
public class LoginHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String homemain = "homemain.jsp";
	private static final String login = "login.jsp";
	private static final String home = "home.jsp";
	private static final String viewGrocery = "viewegrocery.jsp";

	RequestDispatcher requestDispatcher = null;

	public LoginHomeController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("cancel")) {
			response.sendRedirect("home.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String navigation = "";

		String username = request.getParameter("uname");
		String password = request.getParameter("psw");

		BeenLogin beenEMS = new BeenLogin();
		beenEMS.setUsername(username);
		beenEMS.setPassword(password);

		LoginServiceEMS loginCheck = new LoginServiceEMS();

		String result = loginCheck.check(beenEMS);

		if (result.equals("success")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			String check = (String) session.getAttribute("username");
			if (check != null) {
				ArrayList<GroceryBeen> groceryBeens = new ArrayList<GroceryBeen>();
				GroceryService groceryService = new GroceryService();
				try {
					groceryBeens = groceryService.getGrocery();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", groceryBeens);
				navigation = viewGrocery;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else {
			request.setAttribute("msg", "Enter Valid Username/Password");
			navigation = login;
		}
		requestDispatcher = request.getRequestDispatcher(navigation);
		requestDispatcher.forward(request, response);

	}

}
