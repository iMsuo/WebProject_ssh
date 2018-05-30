package service.system;

import java.util.List;

import model.system.Grades;
import dao.system.showgradesDao;

public class showgradesService {
	private showgradesDao showgradesDao;

	public showgradesDao getShowgradesDao() {
		return showgradesDao;
	}

	public void setShowgradesDao(showgradesDao showgradesDao) {
		this.showgradesDao = showgradesDao;
	}
	
	public List<Grades> getGrades(int userid){
		return showgradesDao.getGrades(userid);
	}
}
