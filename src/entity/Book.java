package entity;

import java.io.Serializable;

/**
 * ��ʵ��ͼ����󣨶��߽����鼮ʱ��ʵ���Ͻ����Book����Book���������BookInfo����)
 * @author DELL2017
 *����ʱ��:2020��6��2�� ����5:28:42
 */
public class Book implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String isbn;
private String bookId;//��ͼ����е��ڲ����
//private boolean isCanrent;
private Bookstate state;//ͼ��״̬
private BookInfo bookinfo;
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
 * ͼ��״̬:�����,�ݲ������,�ѽ�����
 * @author DELL2017
 *����ʱ��:2020��6��2�� ����5:34:41
 */
enum Bookstate{
	�����,�ݲ������,�ѽ�����
}