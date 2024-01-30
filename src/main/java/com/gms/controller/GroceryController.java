package com.gms.controller;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.model.GroceryBeen;
import com.gms.service.GroceryService;

@WebServlet("/GroceryController")
public class GroceryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String registerGrocery = "registergroocery.jsp";
	private static final String viewGrocery = "viewegrocery.jsp";
	private static final String login = "login.jsp";
	RequestDispatcher requestDispatcher = null;
	
	public GroceryController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("action");
		String navigation = "";
		if (action.equals("register")) {
			if (check != null) {
				request.setAttribute("name", "save");
				navigation = registerGrocery;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else if (action.equals("cancel")) {
			navigation = "home.jsp";
		} else if (action.equals("update")) {
			if (check != null) {
				GroceryService groceryService = new GroceryService();
				GroceryBeen groceryBeen = new GroceryBeen();
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					groceryBeen = groceryService.getGroceryById(id);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("name", "update");
				request.setAttribute("details", groceryBeen);
				navigation = registerGrocery;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else if (action.equals("delete")) {
			String confirm = request.getParameter("confirm");
			if (check != null) {
				if (!"false".equals(confirm)) {
					GroceryService groceryService = new GroceryService();
					int id = Integer.parseInt(request.getParameter("id"));
					try {
						int reult = groceryService.deleteGrocery(id);
						if (reult == 1) {
							ArrayList<GroceryBeen> groceryBeens = new ArrayList<GroceryBeen>();
							GroceryService groceryService2 = new GroceryService();
							try {
								groceryBeens = groceryService2.getGrocery2();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
							request.setAttribute("details", groceryBeens);
							navigation = viewGrocery;
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					requestDispatcher = request.getRequestDispatcher(login);
				}
			}
		}
		else if (action.equals("add")) {
			if (check != null) {
				request.setAttribute("name", "save");
				navigation = registerGrocery;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else {
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
		}
		requestDispatcher = request.getRequestDispatcher(navigation);
		requestDispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("submit");
		ArrayList<GroceryBeen> arrayList = new ArrayList<GroceryBeen>();
		if (action.equals("save")) {
			if (check != null) {
				GroceryBeen groceryBeen = new GroceryBeen();
				GroceryService groceryService = new GroceryService();
				String name = request.getParameter("name");
				String metrixType = request.getParameter("metrixType");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date expirydateReq = null;
				try {
					expirydateReq = dateFormat.parse(request.getParameter("expiryDate"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date expirydate = new Date(expirydateReq.getTime());
				
				String itemType = request.getParameter("itemType");
				int price = Integer.parseInt(request.getParameter("price"));
				
				
				groceryBeen.setName(name);
				groceryBeen.setMetrixType(metrixType);
				groceryBeen.setQuantity(quantity);
				groceryBeen.setExpiryDate(expirydate);
				groceryBeen.setItemType(itemType);
				groceryBeen.setPrice(price);
				
				String result = groceryService.nameCheck(name);
				arrayList.add(groceryBeen);
				if (result.equals("success")) {
					request.setAttribute("name", "save");
					request.setAttribute("msg", "Name Already Exist");
					request.setAttribute("details", groceryBeen);
					requestDispatcher = request
							.getRequestDispatcher(registerGrocery);
				} else {
					int status = groceryService.insertGrocery(groceryBeen);
					if (status > 0) {
						ArrayList<GroceryBeen> employeBeens = new ArrayList<GroceryBeen>();
						GroceryService employeService2 = new GroceryService();
						try {
							employeBeens = employeService2.getGrocery2();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						request.setAttribute("details", employeBeens);
						requestDispatcher = request
								.getRequestDispatcher(viewGrocery);
					}
				}
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else if (action.equals("Cancel")) {
			if (check != null) {
				ArrayList<GroceryBeen> employeBeens = new ArrayList<GroceryBeen>();
				GroceryService employeService = new GroceryService();
				try {
					employeBeens = employeService.getGrocery();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", employeBeens);
				// navigation=viewemp;
				requestDispatcher = request.getRequestDispatcher(viewGrocery);
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else {
			if (check != null) {
				GroceryBeen groceryBeen = new GroceryBeen();
				GroceryService employeService = new GroceryService();
				ArrayList<GroceryBeen> employeBeens = new ArrayList<GroceryBeen>();
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String metrixType = request.getParameter("metrixType");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date expirydateReq = null;
				try {
					expirydateReq = dateFormat.parse(request.getParameter("expirydate"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date expirydate = new Date(expirydateReq.getTime());
				
				String itemType = request.getParameter("itemType");
				int price = Integer.parseInt(request.getParameter("price"));
				
				groceryBeen.setName(name);
				groceryBeen.setMetrixType(metrixType);
				groceryBeen.setQuantity(quantity);
				groceryBeen.setExpiryDate(expirydate);
				groceryBeen.setItemType(itemType);
				groceryBeen.setPrice(price);
				try {
					int status = employeService.updateGrocery(groceryBeen);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				try {
					employeBeens = employeService.getGrocery2();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", employeBeens);
				request.setAttribute("msg", "record updated successfully");
				requestDispatcher = request.getRequestDispatcher(viewGrocery);
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		}
		requestDispatcher.forward(request, response);
	}
}
