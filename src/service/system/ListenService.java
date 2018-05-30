package service.system;

import java.util.List;

import dao.system.ListenDao;
import model.system.Listensub;

public class ListenService {
	ListenDao listenDao;
	
	
	public ListenDao getListenDao() {
		return listenDao;
	}


	public void setListenDao(ListenDao listenDao) {
		this.listenDao = listenDao;
	}


	public List<Listensub> getques(){
		return listenDao.getques();
	}
	
	public List<Listensub> getanswer(int id){
		return listenDao.getanswer(id);
	}
}
