package dao.system;

import java.util.List;

import model.system.Listensub;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ListenDao extends HibernateDaoSupport{
	
	public int getcounts(){
		String hql = "select count(*) from Mp3";
		Query query = this.getSession().createQuery(hql);  
		return ((Number)query.uniqueResult()).intValue(); 
	}
	
	
	public List<Listensub> getques(){
		int i=(int) (Math.random()*(this.getcounts()-1)+1);
		String hqlString="from Listensub where mp3.id="+i;
		return this.getHibernateTemplate().find(hqlString);
	}
	
	public List<Listensub> getanswer(int id)
	{
		String hqlString="from Listensub where mp3.id="+id;
		return this.getHibernateTemplate().find(hqlString);
	}
	
}
