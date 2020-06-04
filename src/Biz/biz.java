package Biz;
/**
 * 所有业务类的父接口
 * @author DELL2017
 *创建时间:2020年6月4日 上午11:16:18
 */

import java.io.Serializable;
import java.util.Map;

//import entity.BookInfo;

public interface biz<T> extends Serializable {//泛型
	public boolean add(T t);//增
	public boolean del(T t);//删
	public T update(T t);//改
	
	public T findById(String id);//查
	
	public Map<String, T> findAll();
	//BookInfo bookInfoFindByIsbn(String isbn);
	
	

}
