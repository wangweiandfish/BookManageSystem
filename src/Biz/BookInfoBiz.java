package Biz;

import entity.BookInfo;

/**
 * ͼ��ҵ����Ľӿ�
 * ͼ�����ɾ�Ĳ�
 * @author DELL2017
 *����ʱ��:2020��6��4�� ����10:47:49
 */
public interface BookInfoBiz extends biz<BookInfo>{
	/**
	 * ͼ�����
	 * @param isbn
	 * @param outCount
	 * @return
	 */
public boolean outStore(String isbn,int outCount);
/**
 * ͼ�����
 * @param isbn
 * @param inCount
 * @return
 */
public boolean inStore(String isbn,int inCount);
/**
 * ��BookInfo��ͨ��isbn����ѯͼ����Ϣ
 * @param isbn
 * @return
 */
public BookInfo bookInfoFindByIsbn(String isbn);
}
