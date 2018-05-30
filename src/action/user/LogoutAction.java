package action.user;

import javax.jms.Session;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	public String execute()
	{
		try {
			ServletActionContext.getRequest().getSession().removeAttribute("user");
			return "success";
		} catch (Exception e) {
			return "error";
		}
		
	}
}
