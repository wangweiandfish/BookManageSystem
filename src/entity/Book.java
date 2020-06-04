package entity;

import java.io.Serializable;

/**
 * 真实的图书对象（读者借阅书籍时，实际上借的是Book对象，Book对象包含着BookInfo对象)
 * @author DELL2017
 *创建时间:2020年6月2日 下午5:28:42
 */
public class Book implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 7910552002087648505L;
private String isbn;
private String bookId;//在图书馆中的内部编号(唯一性)
//private boolean isCanrent;
private Bookstate state;//图书状态
private BookInfo bookinfo;
/***
 *这里验证传入的obj对象是不是和本对象是同一本书
 *判断BookId是否相同
 */
@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if(!(obj instanceof Book)) return false;
		Book book=(Book)obj;
		
		return bookId.equals(book.getBookId());
	}

public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getBookId() {
	return bookId;
}
public void setBookId(String bookId) {
	this.bookId = bookId;
}
public Bookstate getState() {
	return state;
}
public void setState(Bookstate state) {
	this.state = state;
}
public BookInfo getBookinfo() {
	return bookinfo;
}
public void setBookinfo(BookInfo bookinfo) {
	this.bookinfo = bookinfo;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}

}
/**
 * 图书状态:可外借,暂不可外借,已借阅完
 * @author DELL2017
 *创建时间:2020年6月2日 下午5:34:41
 */
enum Bookstate{
	可外借,暂不可外借,已借阅完
}