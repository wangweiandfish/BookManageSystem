package entity;


import java.util.HashMap;
import java.util.Map;

import Biz.BookInfoBiz;
import Biz.Impl.BookInfoBizImpl_ver1;
import Util.FileUtil;

/**
 * ����
 * @author DELL2017
 *����ʱ��:2020��6��3�� ����10:07:26
 */
public class bookTest {
	public static void Test_model()
	{
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
	
public static void Test_BookInfoBiz() {
	BookInfoBiz  biz=new BookInfoBizImpl_ver1();
	biz.findById("1123-123");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Test_BookInfoBiz();

}
}
