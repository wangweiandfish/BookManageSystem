package entity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import Util.FileUtil;

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

Map<String,BookInfo> info=new HashMap<String, BookInfo>();
info.put(bookinfo.getIsbn(), bookinfo);
FileUtil.SavaBookInfoMap(info);
//System.out.println(book.getBookinfo().getBookName());
info=FileUtil.ReadBookInfoMap();
System.out.println("从文件中读取的信息:");
for(String isbn: info.keySet())
	System.out.println(isbn);
	}

}
