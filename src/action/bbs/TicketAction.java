package action.bbs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import model.system.Lanmu;
import model.system.Ticket;
import model.system.TicketWords;
import model.system.UserInfo;
import service.system.TicketService;
import service.system.UserService;

public class TicketAction {
	ActionContext actionContext=ActionContext.getContext();
    Map request=(Map) actionContext.get("request");
	
	private TicketService ticketService;
	//private UserService userService;
	private int lanmuid;
	private int ticketid;
	private String subjectcontent;
	private String words;
	private int userid=0;
  
	private int pageno=1;
	
	
	
	
	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getSubjectcontent() {
		return subjectcontent;
	}

	public void setSubjectcontent(String subjectcontent) {
		this.subjectcontent = subjectcontent;
	}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	public int getLanmuid() {
		return lanmuid;
	}

	public void setLanmuid(int lanmuid) {
		this.lanmuid = lanmuid;
	}

	public TicketService getTicketService() {
		return ticketService;
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	public String showlanmu(){
		List<Lanmu> Lanmus = ticketService.showLanmus();
		
		request.put("lanmu", Lanmus);
		if(Lanmus.size()>0)
		return "success";
		else {
			return "error";
		}	
	}
	
	public String showtickets(){
		int i;
		Ticket ticket=new Ticket();
		ArrayList<UserInfo> userInfos=new ArrayList<UserInfo>();
		UserInfo userInfo=new UserInfo();
	
		List<Ticket> tickets=ticketService.showTickets(lanmuid,5*(pageno-1),5);
//		System.out.println(tickets.get(0).getLanmu().getLanMuid());
		if(tickets.size()>0)
		{
			Iterator ito=tickets.iterator();
			while(ito.hasNext())
			{
				ticket=(Ticket) ito.next();
				//userInfo=userService.getUserById(ticket.getUserInfo())
				userInfo=ticket.getUserInfo();
				//userInfo.setPassword(null);
				userInfos.add(userInfo);
			}
		}
		request.put("users", userInfos);
		request.put("tickets", tickets);
		request.put("page", pageno);
		int t=ticketService.counts(lanmuid);
		if(t%5==0)
		request.put("limit", t/5);
		else {
			 request.put("limit", t/5+1);
		}
		if(tickets.size()>0)
		return "success";
		else if (tickets==null) {
			return "error";
		}
		else {
			return "error";
		}
	}
	
	
	public String showticketwords()
	{
		List<TicketWords> TicketWords = ticketService.showTicketWords(ticketid,5*(pageno-1),5);
		Ticket ticket=new Ticket() ;
		TicketWords mainWords=new TicketWords();
		ArrayList<UserInfo> userInfos=new ArrayList<UserInfo>();
		UserInfo userInfo=new UserInfo();
		
		if(TicketWords!=null&&TicketWords.size()>0)
		{
			Iterator ito=TicketWords.iterator();
			while(ito.hasNext())
			{
				mainWords=(TicketWords) ito.next();
				userInfo=mainWords.getUserInfo();
				//userInfo.setPassword(null);
				userInfos.add(userInfo);
				ticket = TicketWords.get(0).getTicket();
				userInfo=ticket.getUserInfo();
				//userInfo.setPassword(null);
			}
			
		}
		else{
		ticket=ticketService.getTicketbyid(ticketid);
		userInfo=ticket.getUserInfo();
		}
		
		int t=ticketService.countswords(ticketid);
		if(t%5==0)
		request.put("limit", t/5);
		else {
			 request.put("limit", t/5+1);
		}
		request.put("page", pageno);
		request.put("ownuser", userInfo);
		request.put("ticket", ticket);
		request.put("mainusers", userInfos);
		request.put("ticketwords", TicketWords);
		if (TicketWords!=null&&TicketWords.size()>0) {
			return "success";
		}
		else {
			return "error";
		}
	}
	
	
	public String publishticket()
	{
		if(userid==0)
		{
			return "error"	;	
		}
		else {
		boolean flag=true;
		flag=ticketService.publishtickets(userid, lanmuid, subjectcontent, words);
		if(flag)
		{
			ServletActionContext.getRequest().setAttribute("tipMessage", "发表成功！");
			ServletActionContext.getRequest().setAttribute("url", "/WebProject/showtickets?lanmuid="+lanmuid);
			return "success";
		}
		else {
			return "error";
		}
		}
	}
	
	
	public String addreply(){
		if(userid==0)
		{
			return "error"	;	
		}
		else {
		boolean flag=true;
		flag=ticketService.addreply(userid, ticketid, words);
		if(flag)
		{
			ServletActionContext.getRequest().setAttribute("tipMessage", "发表成功！");
			ServletActionContext.getRequest().setAttribute("url", "/WebProject/showticketwords?ticketid="+ticketid);
			return "success";
		}
		else {
			return "error";
		}
		}
	}
}
