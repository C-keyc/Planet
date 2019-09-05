package vc.server.dao;

import java.util.List;

import vc.list.common.Book;
import vc.list.common.BookRecord;


public interface BookDao {
	
	List<BookRecord> getAllBook(String id);//返回所有商品
	Book QueryBookName(String name);//按书籍名称查询
	Book QueryBookID(String id);//按书籍编号查询
	List<Book> QueryBookWriter(String writer);//按书籍作者查询
	boolean AddBook(Book bk);
	boolean DeleteBook(Book bk);
	
	
	

}
