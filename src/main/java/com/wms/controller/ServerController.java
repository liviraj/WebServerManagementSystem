package com.wms.controller;

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

import com.wms.model.ServerBeen;
import com.wms.service.ServerService;

@WebServlet("/ServerController")
public class ServerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String registerServer = "registerserver.jsp";
	private static final String viewServer = "vieweserver.jsp";
	private static final String login = "login.jsp";
	RequestDispatcher requestDispatcher = null;

	public ServerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("action");
		String navigation = "";
		if (action.equals("register")) {
			if (check != null) {
				request.setAttribute("name", "save");
				navigation = registerServer;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else if (action.equals("cancel")) {
			navigation = "home.jsp";
		} else if (action.equals("update")) {
			if (check != null) {
				ServerService serverService = new ServerService();
				ServerBeen serverBeen = new ServerBeen();
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					serverBeen = serverService.getServerById(id);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("name", "update");
				request.setAttribute("details", serverBeen);
				navigation = registerServer;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else if (action.equals("delete")) {
			String confirm = request.getParameter("confirm");
			if (check != null) {
				if (!"false".equals(confirm)) {
					ServerService serverService = new ServerService();
					int id = Integer.parseInt(request.getParameter("id"));
					try {
						int reult = serverService.deleteServer(id);
						if (reult == 1) {
							ArrayList<ServerBeen> serverList = new ArrayList<ServerBeen>();
							ServerService serverService2 = new ServerService();
							try {
								serverList = serverService2.getServer2();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
							request.setAttribute("details", serverList);
							navigation = viewServer;
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
		} else if (action.equals("add")) {
			if (check != null) {
				request.setAttribute("name", "save");
				navigation = registerServer;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else {
			if (check != null) {
				ArrayList<ServerBeen> serverBeens = new ArrayList<ServerBeen>();
				ServerService serverService = new ServerService();
				try {
					serverBeens = serverService.getServer();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", serverBeens);
				navigation = viewServer;
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		}
		requestDispatcher = request.getRequestDispatcher(navigation);
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("submit");
		ArrayList<ServerBeen> arrayList = new ArrayList<ServerBeen>();
		if (action.equals("save")) {
			if (check != null) {
				ServerBeen serverBeen = new ServerBeen();
				ServerService serverService = new ServerService();
				String operatingSystem = request.getParameter("operatingSystem");
				String serverName = request.getParameter("serverName");
				String ram = request.getParameter("ram");

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date expirydateReq = null;
				try {
					expirydateReq = dateFormat.parse(request.getParameter("expiryDate"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date expirydate = new Date(expirydateReq.getTime());

				String hardDiskSize = request.getParameter("hardDiskSize");
				String availability = request.getParameter("availability");

				serverBeen.setServerName(serverName);
				serverBeen.setOperatingSystem(operatingSystem);
				serverBeen.setRam(ram);
				serverBeen.setExpiryDate(expirydate);
				serverBeen.setHardDiskSize(hardDiskSize);
				serverBeen.setAvailability(availability);

				String result = serverService.nameCheck(operatingSystem);
				arrayList.add(serverBeen);
				if (result.equals("success")) {
					request.setAttribute("name", "save");
					request.setAttribute("msg", "Server Already Exist");
					request.setAttribute("details", serverBeen);
					requestDispatcher = request.getRequestDispatcher(registerServer);
				} else {
					int status = serverService.insertServer(serverBeen);
					if (status > 0) {
						ArrayList<ServerBeen> employeBeens = new ArrayList<ServerBeen>();
						ServerService employeService2 = new ServerService();
						try {
							employeBeens = employeService2.getServer2();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						request.setAttribute("details", employeBeens);
						requestDispatcher = request.getRequestDispatcher(viewServer);
					}
				}
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else if (action.equals("Cancel")) {
			if (check != null) {
				ArrayList<ServerBeen> serverBeens = new ArrayList<ServerBeen>();
				ServerService serverService = new ServerService();
				try {
					serverBeens = serverService.getServer();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", serverBeens);
				// navigation=viewemp;
				requestDispatcher = request.getRequestDispatcher(viewServer);
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		} else {
			if (check != null) {
				ServerBeen serverBeen = new ServerBeen();
				ServerService serverService = new ServerService();
				ArrayList<ServerBeen> serverBeens = new ArrayList<ServerBeen>();
				int id = Integer.parseInt(request.getParameter("serverId"));
				String operatingSystem = request.getParameter("operatingSystem");
				String serverName = request.getParameter("serverName");
				String ram = request.getParameter("ram");

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date expirydateReq = null;
				try {
					expirydateReq = dateFormat.parse(request.getParameter("expiryDate"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date expirydate = new Date(expirydateReq.getTime());

				String hardDiskSize = request.getParameter("hardDiskSize");
				String availability = request.getParameter("availability");

				serverBeen.setServerName(serverName);
				serverBeen.setOperatingSystem(operatingSystem);
				serverBeen.setRam(ram);
				serverBeen.setExpiryDate(expirydate);
				serverBeen.setHardDiskSize(hardDiskSize);
				serverBeen.setAvailability(availability);
				try {
					int status = serverService.updateServer(serverBeen);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				try {
					serverBeens = serverService.getServer2();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				request.setAttribute("details", serverBeens);
				request.setAttribute("msg", "record updated successfully");
				requestDispatcher = request.getRequestDispatcher(viewServer);
			} else {
				requestDispatcher = request.getRequestDispatcher(login);
			}
		}
		requestDispatcher.forward(request, response);
	}
}
