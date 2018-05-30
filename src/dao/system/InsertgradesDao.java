package dao.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.system.Grades;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InsertgradesDao extends HibernateDaoSupport{
	UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}



	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	public int getcount(int userid,int exampart){
		try {
			String hql = "select count(*) from Grades where userid="+userid+"and exampart="+exampart;
			Query query = this.getSession().createQuery(hql);  
			return ((Number)query.uniqueResult()).intValue();   
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}
	
	
	public Grades getearliestgrade(int userid,int exampart)
	{
		String hqlString="from Grades where userid="+userid+"and exampart="+exampart+"order by datetime";
		List<Grades> find = this.getHibernateTemplate().find(hqlString);
		return find.get(0);
		
	}
	
	public void insertgrades(int userid,int exampart,String grade){
		int i=this.getcount(userid, exampart);
		this.getHibernateTemplate().setFlushMode(2) ;
		Grades grades=new Grades();
		System.out.println("ins");
		System.out.println(userid);
		System.out.println(exampart);
		System.out.println(i);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		if(i<5)
		{
			grades.setGrades(grade);
			grades.setDatetime(df.format(new Date()));
			grades.setExampart(exampart);
			grades.setUserInfo(userDao.getUserById(userid));
			grades.setId(0);
			this.getHibernateTemplate().save(grades);
		}
		else {
			grades=this.getearliestgrade(userid, exampart);
			grades.setDatetime(df.format(new Date()));
			grades.setGrades(grade);
			grades.setExampart(exampart);
			this.getHibernateTemplate().update(grades);
		}
		this.getHibernateTemplate().flush(); 
	}
}
