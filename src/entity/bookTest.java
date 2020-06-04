package entity;


import java.util.HashMap;
import java.util.Map;

import Biz.BookInfoBiz;
import Biz.Impl.BookInfoBizImpl_ver1;
import Util.FileUtil;

/**
 * 测试
 * @author DELL2017
 *创建时间:2020年6月3日 上午10:07:26
 */
public class bookTest {
	public static void Test_model()
	{
		BookInfo bookinfo=new BookInfo();
		bookinfo.setIsbn("123-124");
		bookinfo.setBookName("恶意");

		Book book= new Book();
		book.setIsbn("123-124");//扫描入库
		bookinfo.add(book);

		Map<String,BookInfo> info=new HashMap<String, BookInfo>();
		info.put(bookinfo.getIsbn(), bookinfo);
		FileUtil.SavaBookInfoMap(info);
		//System.out.println(book.getBookinfo().getBookName());
		info=FileUtil.ReadBookInfoMap();
		System.out.println("从文件中读取的信息:");
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
