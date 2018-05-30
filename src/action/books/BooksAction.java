package action.books;

import java.util.List;
import java.util.Map;

import model.system.BookList;
import service.system.BooksService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BooksAction extends ActionSupport{
	
	ActionContext actionContext=ActionContext.getContext();
    Map request=(Map) actionContext.get("request");
	
	
	
	private BooksService booksService;
    
	private int id;
	private int booklistid;
	
	
	public int getBooklistid() {
		return booklistid;
	}

	public void setBooklistid(int booklistid) {
		this.booklistid = booklistid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BooksService getBooksService() {
		return booksService;
	}

	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}
	
	
	public String  showbooks(){
		try {
			request.put("bookslists", booksService.getallbookslist());
			request.put("hotbook", booksService.hotbooks());
			request.put("lastbook", booksService.lastbooks());
			request.put("random", booksService.getrandon());
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	}
	
	public String showbooklists(){
		try {
			request.put("books", booksService.showbooklists(booklistid));
		    request.put("lists", booksService.getbBookList(booklistid));
//			System.out.println(booksService.showbooklists(booklistid).get(0).ge);
			
			return "success";
		}
		catch (Exception e) {
			// TODO: handle exception
			return "error";
		}

	}
	public String showbook(){
		try {
			request.put("book", booksService.getbookbyid(id));
			booksService.addcount(id);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	}
	
}
