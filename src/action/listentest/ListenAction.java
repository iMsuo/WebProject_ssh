package action.listentest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.system.Listensub;
import model.system.UserInfo;
import service.system.InsertgradesService;
import service.system.ListenService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListenAction extends ActionSupport{
	private ListenService listenService;
	private InsertgradesService insertgradesService;
	Map session = ActionContext.getContext().getSession(); 
	UserInfo user = (UserInfo)session.get("user");
	
	
	ActionContext actionContext=ActionContext.getContext();
    Map request=(Map) actionContext.get("request");
	private int mp3id;
	private String que1=null;
	private String que2=null;
	private String que3=null;
	private String que4=null;
	
	
	
	public InsertgradesService getInsertgradesService() {
		return insertgradesService;
	}


	public void setInsertgradesService(InsertgradesService insertgradesService) {
		this.insertgradesService = insertgradesService;
	}


	public int getMp3id() {
		return mp3id;
	}


	public void setMp3id(int mp3id) {
		this.mp3id = mp3id;
	}


	public String getQue1() {
		return que1;
	}


	public void setQue1(String que1) {
		this.que1 = que1;
	}


	public String getQue2() {
		return que2;
	}


	public void setQue2(String que2) {
		this.que2 = que2;
	}


	public String getQue3() {
		return que3;
	}


	public void setQue3(String que3) {
		this.que3 = que3;
	}


	public String getQue4() {
		return que4;
	}


	public void setQue4(String que4) {
		this.que4 = que4;
	}


	public ListenService getListenService() {
		return listenService;
	}


	public void setListenService(ListenService listenService) {
		this.listenService = listenService;
	}


	public String getques(){
		try {
			List<Listensub> listensub=listenService.getques();
			request.put("ques", listensub);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	}
	
	
	public String getgrades(){
		int i=4;
		int grade=0;
		ArrayList<String> list=new ArrayList<String>();
		list.add(que1);
		list.add(que2);
		list.add(que3);
//		System.out.println(mp3id);
		if(que4==null)
			i=3;
		else {
			list.add(que4);
		}
		List<Listensub> getanswer = listenService.getanswer(mp3id);
		for(int j=0;j<i;j++){
//			System.out.println("1"+getanswer.get(j).getTrueAnswer()+"1");
//			System.out.println("1"+list.get(j)+"1");
			if(getanswer.get(j).getTrueAnswer().equals(list.get(j)))
			{
//				System.out.println(getanswer.get(j).getTrueAnswer());
//				System.out.println(list.get(j));
				grade=grade+1;
			}
		}
//		System.out.println(grade);
		if(grade==i)
			grade=100;
		else {
				grade=grade*(100/i);	
			}
		System.out.println(user.getId());
		System.out.println(grade);
		insertgradesService.insertgrades(user.getId(),1,Integer.toString(grade));
		request.put("grade", grade);
		return "success";
	}
}
