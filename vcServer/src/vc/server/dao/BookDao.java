package vc.server.dao;

import java.util.List;

import vc.list.common.Book;
import vc.list.common.BookRecord;


public interface BookDao {
	
	List<BookRecord> getAllBook(String id);//����������Ʒ
	List<Book> QueryBookName(String name);//���鼮���Ʋ�ѯ
	Book QueryBookID(String id);//���鼮��Ų�ѯ
	List<Book> QueryBookWriter(String writer);//���鼮���߲�ѯ
	int AddBook(Book bk);
	boolean DeleteBook(Book bk);
	
	
	

}
