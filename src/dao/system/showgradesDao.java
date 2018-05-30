package dao.system;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import model.system.Grades;

public class showgradesDao extends HibernateDaoSupport{
	
	public List<Grades> getGrades(int userid)
	{
		String hqlString="from Grades where userid="+userid;
		List<Grades> gradeslist=this.getHibernateTemplate().find(hqlString);
		return gradeslist;
	}
}
