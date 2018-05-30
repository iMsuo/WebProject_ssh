package dao.system;

import java.util.List;
import model.system.UserInfo;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDao  extends HibernateDaoSupport{
	public void add(UserInfo m)
	{
	//getHibernateTemplate().save(m);
		HibernateTemplate template=super.getHibernateTemplate();
		template.setFlushMode(template.FLUSH_EAGER);
		template.save(m);
		
	}
	@SuppressWarnings("unchecked")
	public List<UserInfo> showAllUsers()
	{
	return getHibernateTemplate().find("from user");
	}
	public void update(UserInfo m)
	{
	        getHibernateTemplate().update(m);
	}
	public void delete(String id)
	{
	getHibernateTemplate().delete(getHibernateTemplate().get(UserInfo.class, id));
	}

	public UserInfo getUserById(int id)
	{
	UserInfo m=(UserInfo)getHibernateTemplate().get(UserInfo.class, id);
	//m.setPassword(null);
	return m;
	}
	
	//普通用户登录验证
	@SuppressWarnings("unchecked")
	public UserInfo checkUser(String userName,String userPassword){
		UserInfo userInfo=new UserInfo();
	  boolean flag = false;
	  String hql = "from UserInfo as user where user.username = '"+userName+"' and user.password = '"+userPassword+"'";
	  List<UserInfo> userList = this.getHibernateTemplate().find(hql);
	  if(userList.size()>0){
		  userInfo=userList.get(0);
	  }
	  return userInfo;
	}
	
	//用户注册
	public boolean insertUser(String userName,String userPassword,String email,String headpic)
	{
		
		boolean flag = false;
		UserInfo userInfo=new UserInfo();
		userInfo.setEmail(email);
		userInfo.setPassword(userPassword);
		userInfo.setUsername(userName);
		userInfo.setHeaderpic(headpic);
//		System.out.println(userInfo.getHeaderpic());
//		System.out.println(userInfo.getPassword());
		userInfo.setId(0);
		try {
			//System.out.println(userInfo.getUsername());
			add(userInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public void changpwd(int id,String pwd){
		this.getHibernateTemplate().setFlushMode(2) ;
		UserInfo userById = this.getUserById(id);
		userById.setPassword(pwd);
		this.getHibernateTemplate().update(userById);
		this.getHibernateTemplate().flush(); 
	} 


}
