package Biz.Impl;

import java.util.Map;

import Biz.BookInfoBiz;
import Util.FileUtil;
import entity.BookInfo;

/**
 * BookInfoBiz�ĵ�һ���汾BookInfoʵ����
 * @author DELL2017
 *����ʱ��:2020��6��4�� ����3:26:44
 */
public class BookInfoBizImpl_ver1 implements BookInfoBiz{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3900928059701481047L;

	
	

	@Override
	public boolean add(BookInfo bookinfo) {
		//1.�õ����е�BookInfoMap
		//2.�򼯺���д�봫���BookInfo����
		//3.��map����д���ļ�
		if(bookinfo==null) return false;
		
		Map<String,BookInfo> bookinfoMap=findAll();
		if(bookinfoMap==null) return false;
		if(bookinfoMap.containsKey(bookinfo.getIsbn())) {
			//�жϴ����ͼ����Ϣ�Ƿ��ظ�
			return false;
		}
		bookinfoMap.put(bookinfo.getIsbn(), bookinfo);
		FileUtil.SavaBookInfoMap(bookinfoMap);
		return true;
	}

	@Override
	public boolean del(BookInfo bookinfo) {
		if(bookinfo==null) return false;
		
		Map<String,BookInfo> bookinfoMap=findAll();
		if(bookinfoMap==null) return false;
		if(!bookinfoMap.containsKey(bookinfo.getIsbn())) {
			return false;
		}
		bookinfoMap.remove(bookinfo.getIsbn());//��mapɾ��
		FileUtil.SavaBookInfoMap(bookinfoMap);//������д���ļ�
		return false;
	}

	@Override
	public BookInfo update(BookInfo bookinfo) {
		if(bookinfo==null) return null;
		Map<String,BookInfo> bookinfoMap=findAll();
		if(bookinfoMap==null) return null;
		if(!bookinfoMap.containsKey(bookinfo.getIsbn())) {
			return null;
		}
		bookinfoMap.put(bookinfo.getIsbn(), bookinfo);
		FileUtil.SavaBookInfoMap(bookinfoMap);
		return null;
	}

	@Override
	public BookInfo findById(String id) {
		//��ʵ�ִ˷������׳��˲���
		throw new UnsupportedOperationException("��BookInfoBiz���в�֧��ͨ��Id��ѯͼ��");
		
	}

	@Override
	public Map<String, BookInfo> findAll() {
	
		return FileUtil.ReadBookInfoMap();
	}

	@Override
	public boolean outStore(String isbn, int outCount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inStore(String isbn, int inCount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookInfo bookInfoFindByIsbn(String isbn) {
		if(isbn==null|| "".equals(isbn)) return null;
		Map<String,BookInfo> bookinfoMap=findAll();
		if(bookinfoMap==null) return null;
		if(!bookinfoMap.containsKey(isbn)) {
			return null;
		}
		return bookinfoMap.get(isbn);
	}

	

}
