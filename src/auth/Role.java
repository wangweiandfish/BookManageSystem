package auth;
/**
 * ��ɫ��
 * @author DELL2017
 *����ʱ��:2020��6��5�� ����3:06:32
 */

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import Biz.BookInfoBiz;
import Biz.bizFactory;
public class Role implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -7321385440554992585L;
private String name; //��ʾ���û�������ʾ����
private String key;//��ӦȨ�������ļ��е�Ȩ��key
private List<String> permisstions;//Ȩ�޼���-������auth.role_permissions.properties
private BookInfoBiz bookinfobiz;

public Role() {
	setName("Ĭ��Role");
	setKey("default");
	creatPermisstions(key);
	//bookinfobiz=new BookInfoBizImpl_ver1();//Ӳ����ʵ��,���Ըĳɹ���ģʽ���������ʵ��
	bookinfobiz=(BookInfoBiz) bizFactory.getBiz("bookinfobiz");
}
/**
 * ����һ��������ɫ����Ȩ��key�Ľ�ɫ����
 * Ȩ��key��Ӧ���ַ����ָ������,���ֵ��permisstions����
 * @param name
 * @param key
 */
public Role(String name,String key) {
	setName(name);
	setKey(key);
	//��ȡ�����ļ�
	creatPermisstions(key);
	bookinfobiz=(BookInfoBiz) bizFactory.getBiz("bookinfobiz");
}

private void creatPermisstions(String key) {
	Properties props=new Properties();
	try {
		//����������ļ�
		props.load(Role.class.getResourceAsStream("Role_Permissions.properties"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String strpermisstion=props.getProperty(key);//��ö�Ӧ��key
	
	if(permisstions==null) permisstions=new ArrayList<String>();
	permisstions.clear();//ȷ��Ϊ��
	//permisstions.addAll(Arrays.asList(strpermisstion.split(",")));//�ַ���-����-����   
	String[] permisstionArray=strpermisstion.split(",");
	for(String per:permisstionArray)
	{
		if("".equals(per)) continue;
		permisstions.add(per.trim());//Ȩ�����
		
	}
}
/**
 * ��֤��ǰ��ɫ���Ƿ���Ȩ��ִ�д���Ĳ�����(ҵ�񷽷�)
 * @param optMethod
 * @return
 */
private boolean checkPermisston(String optMethod) {
	if(permisstions==null||permisstions.size()==0) {
		return false;
	}
	return true;
}
public boolean instore(String isbn,int inCount) {
	//��֤��ǰ��ɫ��û��Ȩ��ִ��������
	return true;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}

public List<String> getPermisstions() {
	return permisstions;
}

public void setPermisstions(List<String> permisstions) {
	this.permisstions = permisstions;
}

public BookInfoBiz getBookinfobiz() {
	return bookinfobiz;
}

public void setBookinfobiz(BookInfoBiz bookinfobiz) {
	this.bookinfobiz = bookinfobiz;
}

}
