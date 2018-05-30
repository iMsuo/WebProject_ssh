package service.system;

import java.util.List;

import model.system.BookList;
import model.system.Books;
import model.system.ShowBookList;
import dao.system.BooksDao;

public class BooksService {

	BooksDao booksDao;

	public BooksDao getBooksDao() {
		return booksDao;
	}

	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
	public List<BookList> getallbookslist(){
		return booksDao.getallbookslist();
	}
	
	
	public BookList getbBookList(int bookllistid){
		return booksDao.getbBookList(bookllistid);
	}
	public List<ShowBookList> showbooklists(int bookllistid)
	{
		return booksDao.showbooklists(bookllistid);
	}
	
	public void addcount(int id){
		booksDao.addcount(id);
	}
	
	public Books getbookbyid(int id){
		return booksDao.getbookbyid(id);
	}
	
	public Books hotbooks(){
		return booksDao.hotbooks();
	}
	public Books lastbooks(){
		return booksDao.lastbooks();
	}
	
	public Books getrandon(){
		return booksDao.getrandon();
	}
}
