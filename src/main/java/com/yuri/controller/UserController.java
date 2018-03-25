package com.yuri.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
*    
* @Title: UserController.java  
* @Package: com.yuri.controller
* @Project: AjaxProject
* @Description: 用户登录控制器(仅做练习测试,代码存在硬编码)
* @date: 2018年3月25日 下午3:29:52
* @author: yuriFeng
* Contect: yuri_feng@outlook.com 
*      
*/
@WebServlet(urlPatterns = "/user/check")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = -6024402299084946359L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从请求中获取参数
		String username = request.getParameter("username");

		// User user = userService.findUserByName(username);

		//这是响应模式为纯文本应答
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 判断条件,想前台输出响应文本
		if ("tim".equalsIgnoreCase(username) || "linda".equalsIgnoreCase(username)) {
			out.print("1");
		} else {
			out.print("0");
		}
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
