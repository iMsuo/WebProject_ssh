package dao.system;


import java.util.List;

import model.system.Words;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class WordsDao extends HibernateDaoSupport{
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Words> testwordsdao(){
		
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		final String tempsql = "select * from words  ORDER BY  RAND() LIMIT 110";
		//List<Words>wordsList=(List<Words>)this.getHibernateTemplate().find(hql);
		
		 //List<Words> list=session.createQuery(tempsql).list();
		Query q = session.createSQLQuery(tempsql).addEntity(Words.class);
		List<Words> list= (List<Words>)q.list();

//		Words e=new Words();
//		e.setFs("12");
//		wordsList.add(e);
//		System.out.println(list.get(0));
//		for(Words w:list)
//		{
////			System.out.println(w.getFs());
////			System.out.println(w.getGqfc());
////			System.out.println(w.getGqs() );
//			System.out.println(w.getWord());
//			System.out.println(w.getMeaning());
//		}
		System.out.println(123);
		return list;
	}
	
}
