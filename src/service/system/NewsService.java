package service.system;

import java.util.List;

import model.system.News;


import dao.system.NewsDao;

public class NewsService {
	NewsDao newsDao;
	
	
	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public List<News> getnews(int pageNo,int pageSize)
	{
		return newsDao.getnews(pageNo, pageSize);
	}
	
	public List<News> getarticles(int pageNo,int pageSize)
	{
		return newsDao.getarticles(pageNo, pageSize);
	}
	public int newscounts(){
		return newsDao.newscounts();
	}
	public int articlecounts(){
		return newsDao.articlecounts();
	}
	public int counts(){
		return newsDao.counts();
	}
	
	public List<News> getallnews(int pageNo,int pageSize)
	{
		return newsDao.getallnews(pageNo, pageSize);
	}
	
	public List<News> hotnews(){
		return newsDao.hotnews();
	}
	
	public List<News> appointednews(int id)
	{
		return newsDao.appointednews(id);
	}
	
	public void addcount(int id){
		newsDao.addcount(id);
	}
	public List<News> hotnews(int part){
		return newsDao.hotnews(part);
	}
	
}
