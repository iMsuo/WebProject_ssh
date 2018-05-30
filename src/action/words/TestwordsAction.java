package action.words;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.system.UserInfo;
import model.system.Words;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.Request;

import com.opensymphony.xwork2.ActionContext;

import service.system.InsertgradesService;
import service.system.WordsService;

public class TestwordsAction {
	private Integer id;
	private String word;
	private String gqs;
	private String gqfc;
	private String xzfc;
	private String fs;
	private String meaning;
	private String lx;
	private WordsService wordsService;
	
	Map session = ActionContext.getContext().getSession(); 
	UserInfo user = (UserInfo)session.get("user");
	private InsertgradesService insertgradesService;
	
	public InsertgradesService getInsertgradesService() {
		return insertgradesService;
	}

	public void setInsertgradesService(InsertgradesService insertgradesService) {
		this.insertgradesService = insertgradesService;
	}

	public WordsService getWordsService() {
		return wordsService;
	}

	public void setWordsService(WordsService wordsService) {
		this.wordsService = wordsService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getGqs() {
		return gqs;
	}

	public void setGqs(String gqs) {
		this.gqs = gqs;
	}

	public String getGqfc() {
		return gqfc;
	}

	public void setGqfc(String gqfc) {
		this.gqfc = gqfc;
	}

	public String getXzfc() {
		return xzfc;
	}

	public void setXzfc(String xzfc) {
		this.xzfc = xzfc;
	}

	public String getFs() {
		return fs;
	}

	public void setFs(String fs) {
		this.fs = fs;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}


	
	
	public String execute() {
		
		
		int i,j=0,m=0,n=0,t=0;
		String wrongmeaning[]=new String[15];
		String truemeaning[]=new String[5];
		int x[]=new int[5];		
		String grade="0";
		String meaning[]=new String[20];
		
		try {
		HttpServletRequest request = ServletActionContext.getRequest();
		grade=request.getParameter("grade1");
		List<Words> listWords=wordsService.testwordsservices();
//		for(Words w:listWords)
//		{
////			System.out.println(w.getFs());
////			System.out.println(w.getGqfc());
////			System.out.println(w.getGqs() );
//			System.out.println(w.getWord());
//			System.out.println(w.getMeaning());
//		}	
//		System.out.println(listWords.get(0).getFs());
		request.setAttribute("words", listWords);
		System.out.println(grade);
		if(grade==null)
		{
			return "success1";
		}
		else {
			  for(i=0;i<15;i++)
			  {
			    	wrongmeaning[i]=listWords.get(i+40).getMeaning();
			  }
			
			 for(i=0;i<5;i++)
			  {
			    	truemeaning[i]=listWords.get(i).getMeaning();
			  }

	          for(i=0;i<5;i++)
	          {
	        	  x[i]=(int)(Math.random()*3)+4*j;
	        	  j++;
	        	  System.out.println(x[i]);
	          }
	          for(i=0;i<20;i++)
		       {
		    	   if(i!=x[t])
		    	   {
		    		   meaning[i]=wrongmeaning[m];
		    		   m++;
		    	   }
		    	   else {
		    		   meaning[i]=truemeaning[n];
		    		   n++;
		    		   if(t<4)
		    		   {
		    		   t++;
		    		   }
		    	   	}
		       }
			request.getSession().setAttribute("grade1", grade);
	        request.setAttribute("meaning", meaning);
	        request.getSession().setAttribute("truemeaning", truemeaning);
			return "success2";
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "error";
		}
		
	}
	
	

	public String getgrade(){
		int grade2=0;
		HttpServletRequest request = ServletActionContext.getRequest();
		String grade1=(String) request.getSession().getAttribute("grade1");
		String truemeaning[]=(String[]) request.getSession().getAttribute("truemeaning");
		String answer1=request.getParameter("answer1");
		String answer2=request.getParameter("answer2");
		String answer3=request.getParameter("answer3");
		String answer4=request.getParameter("answer4");
		String answer5=request.getParameter("answer5");

       if(answer1==truemeaning[0])
    	   grade2++;
       if(answer2==truemeaning[1])
    	   grade2++;
       if(answer3==truemeaning[2])
    	   grade2++;
       if(answer4==truemeaning[3])
    	   grade2++;
       if(answer5==truemeaning[4])
    	   grade2++;

       
       int sumgrades=(Integer.parseInt(grade1))*50+grade2*100;
       insertgradesService.insertgrades(user.getId(),2,Integer.toString(sumgrades));
		System.out.println("单词量："+sumgrades);
		request.setAttribute("grade", sumgrades);
		return "success";
	}
	
	
	
}
