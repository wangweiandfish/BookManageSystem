package entity;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Biz.BookInfoBiz;

import Biz.Impl.BookInfoBizImpl_ver1;
import Util.FileUtil;
import auth.Role;

/**
 * 测试
 * @author DELL2017
 *创建时间:2020年6月3日 上午10:07:26
 */
public class bookTest {
	public static void Test_Role() {
		Role role1=new Role();
		System.out.println(role1.getName()+"\t"+role1.getKey());
		System.out.println("权限集合:"+role1.getPermisstions());
		
		Role role2=new Role("操作员","operator");
		System.out.println(role2.getName()+"\t"+role2.getKey());
		System.out.println("权限集合:"+role2.getPermisstions());
	}
	public static void Test_BookInfoImpl() {
		Scanner in=new Scanner(System.in);
		BookInfoBiz biz=new BookInfoBizImpl_ver1();
		BookInfo bookinfo=new BookInfo();
		bookinfo.setIsbn("778-965");
		bookinfo.setBookName("三国志");
		for(int i=0; i<5;i++)
		{
			Book book=new Book();
			book.setBookId((i+1)+"");
			book.setIsbn(bookinfo.getIsbn());
			bookinfo.add(book);//将当前这本书添加到书籍信息中
			
		}
		Map<String, BookInfo> infoMap=new HashMap<String, BookInfo>();
		infoMap.put(bookinfo.getIsbn(), bookinfo);
		FileUtil.SavaBookInfoMap(infoMap);
		//出库操作
		System.out.println("要入库的图书出版号:");
		String isbn=in.next();
		boolean isInstoreSuccess=biz.inStore(isbn, 15);
		System.out.println("入库是否成功:"+isInstoreSuccess);
		System.out.println("当前库存:"+new BookInfoBizImpl_ver1().bookInfoFindByIsbn(isbn).getInStoreCount());
		
		boolean isOutStoreSuccess=biz.outStore(isbn, 30);
		System.out.println("入库是否成功:"+isOutStoreSuccess);
		System.out.println("当前库存:"+new BookInfoBizImpl_ver1().bookInfoFindByIsbn(isbn).getInStoreCount());
	}
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
//Test_BookInfoBiz();
//Test_BookInfoImpl();
		Test_Role();
}
}
