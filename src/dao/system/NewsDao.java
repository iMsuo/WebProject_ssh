package dao.system;

import java.sql.SQLException;
import java.util.List;

import model.system.News;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class NewsDao extends HibernateDaoSupport{
	
	
	/**
	* 使用hql 语句进行操作
	*
	* @param hql
	* HSQL 查询语句
	* @param offset
	* 开始取数据的下标
	* @param length
	* 读取数据记录数
	* @return List 结果集
	*/
	@SuppressWarnings("unchecked")
	protected List<News> findByPageBean(final int pageNo, final int pageSize,final String hql) 
			throws Exception {
		List<News> list = null;
		try {
			list = this.getHibernateTemplate().executeFind(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
			Query query = session.createQuery(hql);
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
			List<News> list = query.list();
			return list;
		}
		});
		} catch (Exception e) {
		throw e;
		}
		return list;
	}
	
	public List<News> hotnews(){
		String hql="from News order by counts DESC";
		List<News> listnews;
		try {
			listnews = findByPageBean(0, 5, hql);
			return listnews;	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	
	}
	
	
	public List<News> hotnews(int part){
		String hql="from News where part="+part+" order by counts DESC";
		List<News> listnews;
		try {
			listnews = findByPageBean(0, 5, hql);
			return listnews;	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	
	}
	
	
	
	
	
	//获得所有记录数
	public int newscounts(){
		String hql = "select count(*) from News where part=1";
		Query query = this.getSession().createQuery(hql);  
		return ((Number)query.uniqueResult()).intValue();   
	}
	
	//获得所有记录数
	public int articlecounts(){
		String hql = "select count(*) from News where part=2";
		Query query = this.getSession().createQuery(hql);  
		return ((Number)query.uniqueResult()).intValue();   
	}
	//获得所有记录数
	public int counts(){
		String hql = "select count(*) from News";
		Query query = this.getSession().createQuery(hql);  
		return ((Number)query.uniqueResult()).intValue();   
	}
	
	public List<News> getallnews(int pageNo,int pageSize){
		String hql="from News";
//		List<News> listnews = getHibernateTemplate().find(hqlString);
		try {
			return findByPageBean(pageNo, pageSize, hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	

	public void addcount(int id){
		this.getHibernateTemplate().setFlushMode(2) ;
		List<News> list=this.appointednews(id);
		News news=list.get(0);
		System.out.println(news.getId());
		news.setCounts(news.getCounts()+1);
		this.getHibernateTemplate().update(news);
		this.getHibernateTemplate().flush(); 
	}
	
	
	public List<News> getnews(int pageNo,int pageSize){
		String hql="from News where part="+1;
//		List<News> listnews = getHibernateTemplate().find(hqlString);
		try {
			return findByPageBean(pageNo, pageSize, hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public List<News> getarticles(int pageNo,int pageSize){
		String hql="from News where part=2";
//		List<News> listnews = getHibernateTemplate().find(hqlString);
		try {
			return findByPageBean(pageNo, pageSize, hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public List<News> appointednews(int id){
		String hqlString="from News where id="+id;
		List<News> find = this.getHibernateTemplate().find(hqlString);
		return find;
	}


}
