package action.user;

import org.apache.struts2.ServletActionContext;

import service.system.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	private String username;
	private String password;
	private String	email;
	private UserService userService;
	private String headerpic;
	
	public String getheaderpic() {
		return headerpic;
	}
	public void setheaderpic(String headerpic) {
		this.headerpic = headerpic;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute()
	{
		boolean flag = false;
		flag = userService.insertUser(username, password,email,headerpic);
		if (flag) {
		ServletActionContext.getRequest().setAttribute("tipMessage", "注册成功！");
		ServletActionContext.getRequest().setAttribute("url", "/WebProject/jsp/userlogin.jsp");
		return "success";
		} else {
		ServletActionContext.getRequest().setAttribute("tipMessage", "该用户已存在，请重新注册！");
		ServletActionContext.getRequest().setAttribute("url", "/jsp/register.jsp");
		return "fail";
		}
	}
}
