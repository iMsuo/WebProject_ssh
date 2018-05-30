package service.system;

import dao.system.InsertgradesDao;



public class InsertgradesService {
	private InsertgradesDao insertgradesDao;

	public InsertgradesDao getInsertgradesDao() {
		return insertgradesDao;
	}

	public void setInsertgradesDao(InsertgradesDao insertgradesDao) {
		this.insertgradesDao = insertgradesDao;
	}
	
	
	public void insertgrades(int userid,int exampart,String grade){
		insertgradesDao.insertgrades(userid, exampart, grade);
	}
	

}
