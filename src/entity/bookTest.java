package entity;
/**
 * 测试图书实体类
 * @author DELL2017
 *创建时间:2020年6月3日 上午10:07:26
 */
public class bookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BookInfo bookinfo=new BookInfo();
bookinfo.setIsbn("123-124");
bookinfo.setBookName("恶意");

Book book= new Book();
book.setIsbn("123-124");//扫描入库
bookinfo.add(book);
System.out.println(book.getBookinfo().getBookName());
	}

}
