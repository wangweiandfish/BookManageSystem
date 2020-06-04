package Biz;

import entity.BookInfo;

/**
 * 图书业务类的接口
 * 图书的增删改查
 * @author DELL2017
 *创建时间:2020年6月4日 上午10:47:49
 */
public interface BookInfoBiz extends biz<BookInfo>{
	/**
	 * 图书出库
	 * @param isbn
	 * @param outCount
	 * @return
	 */
public boolean outStore(String isbn,int outCount);
/**
 * 图书入库
 * @param isbn
 * @param inCount
 * @return
 */
public boolean inStore(String isbn,int inCount);
/**
 * 在BookInfo中通过isbn来查询图书信息
 * @param isbn
 * @return
 */
public BookInfo bookInfoFindByIsbn(String isbn);
}
