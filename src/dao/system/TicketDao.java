package dao.system;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import model.system.Lanmu;
import model.system.News;
import model.system.Ticket;
import model.system.TicketWords;
import model.system.UserInfo;

public class TicketDao extends HibernateDaoSupport{
	UserDao userDao;
	
	
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
	protected List<Ticket> findByPageBean(final int pageNo, final int pageSize,final String hql) 
			throws Exception {
		List<Ticket> list = null;
		try {
			list = this.getHibernateTemplate().executeFind(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
			Query query = session.createQuery(hql);
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
			List<Ticket> list = query.list();
			return list;
		}
		});
		} catch (Exception e) {
		throw e;
		}
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	protected List<TicketWords> findByPageBean1(final int pageNo, final int pageSize,final String hql) 
			throws Exception {
		List<TicketWords> list = null;
		try {
			list = this.getHibernateTemplate().executeFind(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
			Query query = session.createQuery(hql);
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
			List<TicketWords> list = query.list();
			return list;
		}
		});
		} catch (Exception e) {
		throw e;
		}
		return list;
	}
	
	
	
	
	public UserDao getUserDao() {
		return userDao;
	}





	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}





	public void add(Ticket ticket){
		HibernateTemplate template=super.getHibernateTemplate();
		template.setFlushMode(template.FLUSH_EAGER);
		template.save(ticket);
	}
	public void addwords(TicketWords ticketwords){
		HibernateTemplate template=super.getHibernateTemplate();
		template.setFlushMode(template.FLUSH_EAGER);
		template.save(ticketwords);
	}
	
	//获得所有记录数
	public int counts(int lanmuid){
		String hql = "select count(*) from Ticket where lanmuid="+lanmuid;
		Query query = this.getSession().createQuery(hql);  
		return ((Number)query.uniqueResult()).intValue();   
	}
	
	//获得所有记录数
	public int countswords(int ticketid){
		String hql = "select count(*) from TicketWords where ticketid="+ticketid;
		Query query = this.getSession().createQuery(hql);  
		return ((Number)query.uniqueResult()).intValue();   
	}

	
	public Lanmu getlanmuByid(int id)
	{
		Lanmu m=(Lanmu)getHibernateTemplate().get(Lanmu.class, id);
		return m;
	}
	public Ticket getTicketbyid(int id)
	{
		Ticket ticket=(Ticket)getHibernateTemplate().get(Ticket.class, id);
		return ticket;
	}
	
	
	
	public List<Lanmu> showLanmus(){
		String hql="from Lanmu";
		List<Lanmu> listlanmu=this.getHibernateTemplate().find(hql);
		if(listlanmu.size()>0)
			return listlanmu;
		else {
			return null;
		}
		}
	public List<Ticket> showTickets(int lanmuid,int pageno,int pagesize){
		String hql="from Ticket where lanmuid="+lanmuid;
		List<Ticket> listticket;
		try {
			listticket = this.findByPageBean(pageno, pagesize, hql);
			return listticket;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;	
		}
	
	}
	
	public List<TicketWords> showTicketWords(int ticketid,int pageno,int pagesize){
		String hqlString="from TicketWords where ticketid="+ticketid;
		List<TicketWords> listTicketWords;
		try {
			listTicketWords = this.findByPageBean1(pageno, pagesize, hqlString);
			return listTicketWords;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public Boolean publishtickets(int userid,int lanmuid,String subjectcontent,String words){
		Ticket ticket=new Ticket();
		ticket.setId(0);
		ticket.setUserInfo(userDao.getUserById(userid));
		ticket.setLanmu(getlanmuByid(lanmuid));
		ticket.setSubjectcontent(subjectcontent);
		ticket.setWords(words);
		try {
			add(ticket);
			//System.out.println("dao-true");
			return true;
			
		} catch (Exception e) {
			//System.out.println("dao-false");
			return false;
		}
		
	}
	
	public Boolean addreply(int userid,int ticketid,String words){
		TicketWords ticketWords=new TicketWords();
		ticketWords.setId(0);
		ticketWords.setTicket(getTicketbyid(ticketid));
		ticketWords.setUserInfo(userDao.getUserById(userid));
		ticketWords.setWords(words);
		
		try {
			addwords(ticketWords);
			//System.out.println("dao-true");
			return true;
			
		} catch (Exception e) {
			//System.out.println("dao-false");
			return false;
		}
	}
}
