package action.news;

import java.util.List;
import java.util.Map;

import model.system.News;

import service.system.NewsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.system.NewsDao;

public class ShowNewsAction extends ActionSupport{
	
	ActionContext actionContext=ActionContext.getContext();
    Map request=(Map) actionContext.get("request");
	
    private int id;
	
	
	private int pageno=1;

	private int part;
	
	

	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}

	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public NewsService getNewsService() {
		return newsService;
	}
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public NewsService newsService;
	
	//只显示news
	public String onlynews(){
		List<News> hotNews=newsService.hotnews(1);
		try {
			int newslimit =newsService.newscounts()/4;
			if(newsService.newscounts()%4!=0)
			{
				newslimit+=1;
			}
			List<News> news=newsService.getnews(4*(pageno-1), 4);
			request.put("limit", newslimit);
			request.put("news", news);
			request.put("page", pageno);
			request.put("hotnews", hotNews);
			return "success";
		} catch (Exception e) {
			return "error";
		}
		
	}
//只显示article
	public String onlyarticle(){
		List<News> hotNews=newsService.hotnews(2);
		try {
			int articlelimit=newsService.articlecounts()/4;
			if(newsService.articlecounts()%4!=0)
			{
				articlelimit+=1;
			}
			List<News> article=newsService.getarticles(4*(pageno-1), 4);
			request.put("limit", articlelimit);
			request.put("news", article);
			request.put("hotnews", hotNews);
			request.put("page", pageno);
			return "success";
		} catch (Exception e) {
			return "error";
		}
		
	}
	
	public  String appointednews(){

			List<News> appNews=newsService.appointednews(id);
			newsService.addcount(id);
			request.put("news",appNews);
			return "success";


	}
	
	
	public String ShowNews(){
		
//		int newslimit =newsService.newscounts()/6;
//		int articlelimit=newsService.articlecounts()/4;
//		
//		if(newsService.newscounts()%6!=0)
//		{
//			newslimit+=1;
//		}
//		if(newsService.articlecounts()%4!=0)
//		{
//			articlelimit+=1;
//		}
		int counts=newsService.counts();
		int limit=counts/6;
		if(counts%6!=0)
			limit+=1;
		
		try {
			List<News> news=newsService.getallnews(6*(pageno-1), 6);
			List<News> hotnews=newsService.hotnews();
//			List<News> article=newsService.getarticles(pageno1, 4);
//			List<News> news=newsService.getnews(pageno2, 4);
////			request.put("newslimit", newslimit);
////			request.put("articlelimit", articlelimit);
//			request.put("news", news);
//			request.put("article", article);
			request.put("hotnews", hotnews);
			request.put("news", news);
			//总页数
			request.put("limit", limit);
			request.put("page", pageno);
			return "success";
			
		} catch (Exception e) {
			return "error";
		}	
	}
}
