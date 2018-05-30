package service.system;

import java.util.List;

import model.system.Lanmu;
import model.system.Ticket;
import model.system.TicketWords;

import dao.system.TicketDao;

public class TicketService {
	TicketDao ticketDao;
	
	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public List<Lanmu> showLanmus(){
		return ticketDao.showLanmus();
	}
	
	public List<Ticket> showTickets(int lanmuid,int pageno,int pagesize)
	{
		return ticketDao.showTickets(lanmuid, pageno, pagesize);
	}
	
	public Ticket getTicketbyid(int id)
	{
		return ticketDao.getTicketbyid(id);
	}
	public List<TicketWords> showTicketWords(int ticketid,int pageno,int pagesize)
	{
		 return ticketDao.showTicketWords(ticketid,pageno,pagesize);
	}
	public Boolean publishtickets(int userid,int lanmuid,String subjectcontent,String words){
		return ticketDao.publishtickets(userid, lanmuid, subjectcontent, words);
	}
	public Boolean addreply(int userid,int ticketid,String words){
		return ticketDao.addreply(userid, ticketid, words);
	}
	
	public int counts(int lanmuid){
		return ticketDao.counts(lanmuid);
	}
	
	public int countswords(int ticketid){
		return ticketDao.countswords(ticketid);
	}
}
