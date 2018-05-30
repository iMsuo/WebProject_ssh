package service.system;

import model.system.UserInfo;
import dao.system.UserDao;

public class UserService {
	private UserDao userDao;

	public UserInfo checkUser(String userName,String userPassword)
	{
	return userDao.checkUser(userName, userPassword);
	}
	
	public boolean insertUser(String userName,String userPassword,String email,String headpic)
	{
	return userDao.insertUser(userName, userPassword,email,headpic);
	}
	
	public UserDao getUserDao() {
	return userDao;
	}

	public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
	}  
	
	public UserInfo getUserById(int id)
	{
		return userDao.getUserById(id);
	}
	public void changpwd(int id,String pwd){
		userDao.changpwd(id, pwd);
	}

}
