package Biz;
/**
 * ����ҵ����ĸ��ӿ�
 * @author DELL2017
 *����ʱ��:2020��6��4�� ����11:16:18
 */

import java.io.Serializable;
import java.util.Map;

//import entity.BookInfo;

public interface biz<T> extends Serializable {//����
	public boolean add(T t);//��
	public boolean del(T t);//ɾ
	public T update(T t);//��
	
	public T findById(String id);//��
	
	public Map<String, T> findAll();
	//BookInfo bookInfoFindByIsbn(String isbn);
	
	

}
