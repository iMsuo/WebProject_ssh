package action.user;

import javax.jms.Session;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import model.system.UserInfo;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;

import com.opensymphony.xwork2.ActionSupport;

import service.system.UserService;

public class LoginAction extends ActionSupport {
//	HttpServletRequest request = ServletActionContext.getRequest();
//	Session session=(Session) request.getSession();
	private static final long serialVersionUID = 3989633817331294940L;
	private String username;
	private String password;
	
	private int id;
	private UserService userService;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserService getUserService() {
	return userService;
	}
	public void setUserService(UserService userService) {
	this.userService = userService;
	}
	public String getUsername() {
	  return username;
	}
	public void setUsername(String username) {
	  this.username = username;
	}
	public String getPassword() {
	  return password;
	}
	public void setPassword(String password) {
	  this.password = password;
	}
	public String execute(){
    
	UserInfo userInfo = new UserInfo();
			userInfo=userService.checkUser(username, password);
	userInfo.setPassword(null);
//	((ServletRequest) session).setAttribute("user",userInfo );
	ServletActionContext.getRequest().getSession().setAttribute("user", userInfo);
	if (userInfo.getId()!=null) {
		ServletActionContext.getRequest().setAttribute("tipMessage", "登录成功！");
		ServletActionContext.getRequest().setAttribute("url", "/WebProject");
	return "success";
	} else {
		ServletActionContext.getRequest().setAttribute("tipMessage", "错误的用户名或密码,请重新登录!");
		ServletActionContext.getRequest().setAttribute("url", "/jsp/userlogin.jsp");
		return "fail";
	}
	}
	
	
	public String changepwd(){
		try {
			userService.changpwd(id, password);
			ServletActionContext.getRequest().getSession().removeAttribute("user");
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	}

}
