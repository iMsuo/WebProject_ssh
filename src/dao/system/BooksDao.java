package dao.system;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import model.system.BookList;
import model.system.Books;
import model.system.News;
import model.system.ShowBookList;

public class BooksDao extends HibernateDaoSupport {

	
	
	
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
	protected List<Books> findByPageBean(final int pageNo, final int pageSize,final String hql) 
			throws Exception {
		List<Books> list = null;
		try {
			list = this.getHibernateTemplate().executeFind(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
			Query query = session.createQuery(hql);
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
			List<Books> list = query.list();
			return list;
		}
		});
		} catch (Exception e) {
		throw e;
		}
		return list;
	}
	public List<BookList> getallbookslist()
	{
		String hqlString="from BookList";
		List<BookList> bookLists=this.getHibernateTemplate().find(hqlString);
		return bookLists;
	}
	
	
	public BookList getbBookList(int bookllistid){
		String hql="from BookList where id ="+bookllistid;
		List<BookList> bookList=this.getHibernateTemplate().find(hql);
		return bookList.get(0);
	}
	
	public List<ShowBookList> showbooklists(int bookllistid){
		BookList bookList=this.getbBookList(bookllistid);
		String hqlString="from ShowBookList where bookList.id="+bookList.getId();
		List<ShowBookList> lists=this.getHibernateTemplate().find(hqlString);
		return lists;
	}
	
	public Books getbookbyid(int id){
		String hql="from Books where id="+id;
		List<Books> lists=this.getHibernateTemplate().find(hql);
		return lists.get(0);
	}
	
	
	public void addcount(int id){
		this.getHibernateTemplate().setFlushMode(2) ;
		Books books=this.getbookbyid(id);
		books.setCounts(books.getCounts()+1);
		this.getHibernateTemplate().update(books);
		this.getHibernateTemplate().flush(); 
	}
	
	public Books hotbooks(){
		String hqlString="from Books order by counts";
		 try {
			return this.findByPageBean(0, 1, hqlString).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public Books lastbooks(){
		String hqlString="from Books order by id DESC";
		 try {
			return this.findByPageBean(0, 1, hqlString).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public int counts(){
		String hql = "select count(*) from Books";
		Query query = this.getSession().createQuery(hql);  
		return ((Number)query.uniqueResult()).intValue();   
	}
	
	public Books getrandon(){
		int trandom=(int) ((Math.random()*(this.counts()-1))+1);
		String hqlString="from Books where id="+trandom;
		try {
			return this.findByPageBean(0, 1, hqlString).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	
}
