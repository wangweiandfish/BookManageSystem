package entity;
/**
 * ����ͼ��ʵ����
 * @author DELL2017
 *����ʱ��:2020��6��3�� ����10:07:26
 */
public class bookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BookInfo bookinfo=new BookInfo();
bookinfo.setIsbn("123-124");
bookinfo.setBookName("����");

Book book= new Book();
book.setIsbn("123-124");//ɨ�����
bookinfo.add(book);
System.out.println(book.getBookinfo().getBookName());
	}

}
