package entity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import Util.FileUtil;

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

Map<String,BookInfo> info=new HashMap<String, BookInfo>();
info.put(bookinfo.getIsbn(), bookinfo);
FileUtil.SavaBookInfoMap(info);
//System.out.println(book.getBookinfo().getBookName());
info=FileUtil.ReadBookInfoMap();
System.out.println("���ļ��ж�ȡ����Ϣ:");
for(String isbn: info.keySet())
	System.out.println(isbn);
	}

}
