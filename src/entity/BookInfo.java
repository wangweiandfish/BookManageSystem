package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 以图书Isbn(出版号)为标识的图书信息
 * 每一个Isbn对应一种图书对象
 * @author DELL2017
 *创建时间:2020年6月2日 下午5:02:38
 *
 */
public class BookInfo implements Serializable{
	
	
//序列化接口

	/**
	 * 
	 */
	private static final long serialVersionUID = 3749803843817332561L;
	private String isbn;    //出版号
	private String bookName; //图书名称
	private String type; //图书类型
	private String author;//作者
	private String publisher;//出版社
	private int inStoreCount ; //储存量
	private Date publishDate;//出版时间
	private double price;//单价
	
	//一个bookinfo对象对应多个book对象
	private List<Book> booklist=new ArrayList<Book>();
	/**
	 * 向同版号的图书信息中添加新的图书对象
	 * @param book
	 */
	public void add(Book book) {
		if(book==null) return;
		if(!isbn.equals(book.getIsbn())) return;
		//如果是同一本书就不需要添加了 
		if(booklist.contains(book)) return;//集合直接调用了类的equals方法
		book.setBookinfo(this);
		booklist.add(book);
	}
	
	//待会重写equals,toString方法
	
	public String getIsbn() {
		return isbn;
	}
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getInStoreCount() {
		return inStoreCount;
	}
	public void setInStoreCount(int inStoreCount) {
		this.inStoreCount = inStoreCount;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
