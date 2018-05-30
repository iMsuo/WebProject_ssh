package action.showgrades;

import java.util.List;
import java.util.Map;

import model.system.Grades;
import model.system.UserInfo;

import service.system.showgradesService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowgradesAction extends ActionSupport{
	private showgradesService showgradesService;
	ActionContext actionContext=ActionContext.getContext();
	Map session=actionContext.getSession();
    Map request=(Map) actionContext.get("request");
	public showgradesService getShowgradesService() {
		return showgradesService;
	}

	public void setShowgradesService(showgradesService showgradesService) {
		this.showgradesService = showgradesService;
	}

	public String execute(){
		try {
			UserInfo userInfo=(UserInfo) session.get("user");
			List<Grades> grades = showgradesService.getGrades(userInfo.getId());
			request.put("grades", grades);
//			System.out.println(grades.get(0).getId());
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}

	}
}
